package com.tencent.mobileqq.troop.membersetting.part;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.specialcare.QQSpecialCareSettingActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.profilecard.api.IProfileCardFeatureApi;
import com.tencent.mobileqq.profilecard.api.IRelationBlacklistApi;
import com.tencent.mobileqq.profilecard.base.report.ProfileCardBlacklistReportConst;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.listener.CheckBlacklistListener;
import com.tencent.mobileqq.profilecard.listener.RelationBlacklistListener;
import com.tencent.mobileqq.profilecard.service.IProfileCardBlacklistService;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qcircle.weseevideo.model.utils.LocaleUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.request.GetAdInfoRequest;
import com.tencent.relation.common.utils.RelationDialogUtil;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.util.QQToastUtil;
import com.tencent.widget.ThemeImageView;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import tencent.im.oidb.cmdBlacklist.RelationBlacklist$BlockRsp;
import tencent.im.oidb.cmdBlacklist.RelationBlacklist$CountBlockListRsp;
import ys2.MemberSettingUIModel;
import zs2.a;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 S2\u00020\u0001:\u0001TB\u0007\u00a2\u0006\u0004\bQ\u0010RJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\u001a\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0002J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0004H\u0002J\b\u0010\u0012\u001a\u00020\u0002H\u0002J\b\u0010\u0013\u001a\u00020\u0002H\u0002J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0004H\u0002J\"\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J*\u0010\u001b\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\"\u0010\u001c\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\"\u0010\u001d\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\"\u0010\u001f\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u001a\u0010 \u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0010\u0010\"\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u0004H\u0002J\b\u0010#\u001a\u00020\u0002H\u0002J\u0018\u0010%\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u0004H\u0002J\u0018\u0010'\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0004H\u0002J\b\u0010(\u001a\u00020\u0002H\u0002J\u0015\u0010+\u001a\b\u0012\u0004\u0012\u00020*0)H\u0016\u00a2\u0006\u0004\b+\u0010,J\u0010\u0010/\u001a\u00020\u00022\u0006\u0010.\u001a\u00020-H\u0016J\"\u00104\u001a\u00020\u00022\u0006\u00100\u001a\u00020\n2\u0006\u00101\u001a\u00020\n2\b\u00103\u001a\u0004\u0018\u000102H\u0016R\u001c\u00107\u001a\b\u0012\u0004\u0012\u00020*0)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R.\u0010=\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030908j\f\u0012\b\u0012\u0006\u0012\u0002\b\u000309`:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\"\u0010C\u001a\u000e\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020@0>8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bA\u0010BR\"\u0010G\u001a\u000e\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020@0D8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bE\u0010FR\"\u0010J\u001a\u000e\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020H0>8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bI\u0010BR\"\u0010L\u001a\u000e\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020H0>8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bK\u0010BR\u0016\u0010P\u001a\u00020M8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bN\u0010O\u00a8\u0006U"}, d2 = {"Lcom/tencent/mobileqq/troop/membersetting/part/MemberSettingAuthorityManagePart;", "Lcom/tencent/mobileqq/troop/membersetting/part/t;", "", LocaleUtils.L_JAPANESE, "", "isSpecialCare", "Ta", "checkState", "Ma", "Oa", "", "resIcon", "", "bindName", "Qa", "Ia", "isChecked", "sa", "ua", "ta", "ra", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "uin", "isCheck", "ea", "needTransferButton", "Ca", "va", "wa", "msg", "Ga", "za", "isBlacklist", "La", "Ra", "isCancelShield", "Ba", "isSuccess", "Sa", "pa", "", "Lcom/tencent/mobileqq/widget/listitem/Group;", "H9", "()[Lcom/tencent/mobileqq/widget/listitem/Group;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "e", "[Lcom/tencent/mobileqq/widget/listitem/Group;", "groups", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/widget/listitem/a;", "Lkotlin/collections/ArrayList;", "f", "Ljava/util/ArrayList;", "configList", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$g;", tl.h.F, "Lcom/tencent/mobileqq/widget/listitem/x;", "specialCareConfig", "Lus2/a;", "i", "Lus2/a;", "friendIntimateConfig", "Lcom/tencent/mobileqq/widget/listitem/x$c$f;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "doNotDisturbConfig", BdhLogUtil.LogTag.Tag_Conn, "blacklistConfig", "Lys2/a;", "D", "Lys2/a;", "uiModel", "<init>", "()V", "E", "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class MemberSettingAuthorityManagePart extends t {

    /* renamed from: C, reason: from kotlin metadata */
    private com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> blacklistConfig;

    /* renamed from: D, reason: from kotlin metadata */
    private MemberSettingUIModel uiModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Group[] groups = new Group[0];

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ArrayList<com.tencent.mobileqq.widget.listitem.a<?>> configList = new ArrayList<>();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> specialCareConfig;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private us2.a<x.b.d, x.c.g> friendIntimateConfig;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> doNotDisturbConfig;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Aa(MemberSettingAuthorityManagePart this$0, String str, boolean z16, boolean z17, Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z17) {
            this$0.La(false);
            ((IProfileCardFeatureApi) QRoute.api(IProfileCardFeatureApi.class)).updateUserIsBlacklistUinFlag(str, false);
        } else {
            this$0.Ma(!z16);
        }
    }

    private final void Ba(Activity activity, boolean isCancelShield) {
        MemberSettingUIModel memberSettingUIModel = null;
        if (NetworkUtil.isNetSupport(getContext())) {
            MemberSettingUIModel memberSettingUIModel2 = this.uiModel;
            if (memberSettingUIModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                memberSettingUIModel2 = null;
            }
            if (memberSettingUIModel2.getIsFriend()) {
                Intent intent = new Intent();
                intent.putExtra(GetAdInfoRequest.SOURCE_FROM, "shiel_uin");
                intent.putExtra("isCancelShield", isCancelShield);
                MemberSettingUIModel memberSettingUIModel3 = this.uiModel;
                if (memberSettingUIModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                    memberSettingUIModel3 = null;
                }
                AllInOne allInOne = memberSettingUIModel3.getAllInOne();
                if (allInOne != null) {
                    intent.putExtra("uin", allInOne.uin);
                }
                intent.addFlags(268435456);
                RouteUtils.startActivityForResult(activity, intent, "/share/toqq/activity", 6);
            } else {
                Intent intent2 = new Intent();
                intent2.putExtra(GetAdInfoRequest.SOURCE_FROM, "source_from_operate_shiel_uin_list");
                intent2.putExtra("isCancelShield", isCancelShield);
                MemberSettingUIModel memberSettingUIModel4 = this.uiModel;
                if (memberSettingUIModel4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                    memberSettingUIModel4 = null;
                }
                AllInOne allInOne2 = memberSettingUIModel4.getAllInOne();
                if (allInOne2 != null) {
                    intent2.putExtra("uin", allInOne2.uin);
                    intent2.putExtra("allinone", allInOne2);
                }
                intent2.addFlags(268435456);
                RouteUtils.startActivityForResult(activity, intent2, "/share/toqq/activity", 7);
            }
            MemberSettingUIModel memberSettingUIModel5 = this.uiModel;
            if (memberSettingUIModel5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                memberSettingUIModel5 = null;
            }
            memberSettingUIModel5.o0(!isCancelShield);
            MemberSettingUIModel memberSettingUIModel6 = this.uiModel;
            if (memberSettingUIModel6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                memberSettingUIModel6 = null;
            }
            MemberSettingUIModel memberSettingUIModel7 = this.uiModel;
            if (memberSettingUIModel7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            } else {
                memberSettingUIModel = memberSettingUIModel7;
            }
            memberSettingUIModel6.g0(memberSettingUIModel.getOpsFlags() | 2);
            xs2.c.f448459a.j(activity);
            Sa(true, isCancelShield);
        } else {
            QQToast.makeText(getContext(), 1, R.string.f131791o, 0).show();
            MemberSettingUIModel memberSettingUIModel8 = this.uiModel;
            if (memberSettingUIModel8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            } else {
                memberSettingUIModel = memberSettingUIModel8;
            }
            Ma(memberSettingUIModel.getIsShield());
        }
        Ra();
    }

    private final void Ca(final Activity activity, final boolean needTransferButton, final String uin, final boolean isCheck) {
        MemberSettingUIModel memberSettingUIModel = this.uiModel;
        if (memberSettingUIModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel = null;
        }
        memberSettingUIModel.s0(needTransferButton);
        QQCustomDialog addBlacklistDialog = ((IProfileCardFeatureApi) QRoute.api(IProfileCardFeatureApi.class)).getAddBlacklistDialog(activity, needTransferButton, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.membersetting.part.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                MemberSettingAuthorityManagePart.Da(MemberSettingAuthorityManagePart.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.membersetting.part.f
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                MemberSettingAuthorityManagePart.Ea(MemberSettingAuthorityManagePart.this, activity, uin, isCheck, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.membersetting.part.g
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                MemberSettingAuthorityManagePart.Fa(MemberSettingAuthorityManagePart.this, isCheck, dialogInterface, i3);
            }
        });
        if (activity != null && !activity.isFinishing() && addBlacklistDialog != null) {
            addBlacklistDialog.show();
            ((IProfileCardBlacklistService) z9().getRuntimeService(IProfileCardBlacklistService.class, "all")).reportItemEvent("imp", ProfileCardBlacklistReportConst.PAGE_ID_PG_GROUP_PROFILE_SETTING, ProfileCardBlacklistReportConst.ELEM_ID_EM_ADD_TO_BLACKLIST_ACTIONSHEET, A9(), new HashMap<String, String>(needTransferButton) { // from class: com.tencent.mobileqq.troop.membersetting.part.MemberSettingAuthorityManagePart$showAddBlacklistDialog$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    String str;
                    if (needTransferButton) {
                        str = "1";
                    } else {
                        str = "2";
                    }
                    put(ProfileCardBlacklistReportConst.ELEM_PARAM_ACTIONSHEET_TYPE, str);
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ boolean containsKey(Object obj) {
                    if (obj == null ? true : obj instanceof String) {
                        return containsKey((String) obj);
                    }
                    return false;
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ boolean containsValue(Object obj) {
                    if (obj == null ? true : obj instanceof String) {
                        return containsValue((String) obj);
                    }
                    return false;
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ Set<Map.Entry<String, String>> entrySet() {
                    return getEntries();
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ /* synthetic */ Object get(Object obj) {
                    if (obj == null ? true : obj instanceof String) {
                        return get((String) obj);
                    }
                    return null;
                }

                public /* bridge */ Set<Map.Entry<String, String>> getEntries() {
                    return super.entrySet();
                }

                public /* bridge */ Set<String> getKeys() {
                    return super.keySet();
                }

                @Override // java.util.HashMap, java.util.Map
                public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
                    return !(obj == null ? true : obj instanceof String) ? obj2 : getOrDefault((String) obj, (String) obj2);
                }

                public /* bridge */ int getSize() {
                    return super.size();
                }

                public /* bridge */ Collection<String> getValues() {
                    return super.values();
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ Set<String> keySet() {
                    return getKeys();
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ /* synthetic */ Object remove(Object obj) {
                    if (obj == null ? true : obj instanceof String) {
                        return remove((String) obj);
                    }
                    return null;
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ int size() {
                    return getSize();
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ Collection<String> values() {
                    return getValues();
                }

                public /* bridge */ boolean containsKey(String str) {
                    return super.containsKey((Object) str);
                }

                public /* bridge */ boolean containsValue(String str) {
                    return super.containsValue((Object) str);
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ String get(Object obj) {
                    if (obj == null ? true : obj instanceof String) {
                        return get((String) obj);
                    }
                    return null;
                }

                public final /* bridge */ String getOrDefault(Object obj, String str) {
                    return !(obj == null ? true : obj instanceof String) ? str : getOrDefault((String) obj, str);
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ String remove(Object obj) {
                    if (obj == null ? true : obj instanceof String) {
                        return remove((String) obj);
                    }
                    return null;
                }

                public /* bridge */ String get(String str) {
                    return (String) super.get((Object) str);
                }

                public /* bridge */ String getOrDefault(String str, String str2) {
                    return (String) super.getOrDefault((Object) str, str2);
                }

                public /* bridge */ String remove(String str) {
                    return (String) super.remove((Object) str);
                }

                @Override // java.util.HashMap, java.util.Map
                public final /* bridge */ boolean remove(Object obj, Object obj2) {
                    if (!(obj == null ? true : obj instanceof String)) {
                        return false;
                    }
                    if (obj2 != null ? obj2 instanceof String : true) {
                        return remove((String) obj, (String) obj2);
                    }
                    return false;
                }

                public /* bridge */ boolean remove(String str, String str2) {
                    return super.remove((Object) str, (Object) str2);
                }
            });
        } else {
            QLog.e("MemberSettingAuthorityManagePart", 1, "showAddBlacklistDialog is error!");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Da(MemberSettingAuthorityManagePart this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MemberSettingUIModel memberSettingUIModel = this$0.uiModel;
        if (memberSettingUIModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel = null;
        }
        memberSettingUIModel.s0(i3 == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ea(MemberSettingAuthorityManagePart this$0, Activity activity, String uin, boolean z16, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(uin, "$uin");
        this$0.va(activity, uin, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fa(MemberSettingAuthorityManagePart this$0, boolean z16, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Ma(!z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ha(MemberSettingAuthorityManagePart this$0, boolean z16, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Ma(!z16);
    }

    private final void Ia() {
        MemberSettingUIModel memberSettingUIModel = this.uiModel;
        MemberSettingUIModel memberSettingUIModel2 = null;
        if (memberSettingUIModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel = null;
        }
        AllInOne allInOne = memberSettingUIModel.getAllInOne();
        if (allInOne != null) {
            MemberSettingUIModel memberSettingUIModel3 = this.uiModel;
            if (memberSettingUIModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            } else {
                memberSettingUIModel2 = memberSettingUIModel3;
            }
            memberSettingUIModel2.K(((IProfileCardFeatureApi) QRoute.api(IProfileCardFeatureApi.class)).isBlacklistUin(allInOne.uin, new CheckBlacklistListener() { // from class: com.tencent.mobileqq.troop.membersetting.part.o
                @Override // com.tencent.mobileqq.profilecard.listener.CheckBlacklistListener
                public final void onResult(boolean z16) {
                    MemberSettingAuthorityManagePart.Ja(MemberSettingAuthorityManagePart.this, z16);
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ja(final MemberSettingAuthorityManagePart this$0, final boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troop.membersetting.part.c
            @Override // java.lang.Runnable
            public final void run() {
                MemberSettingAuthorityManagePart.Ka(MemberSettingAuthorityManagePart.this, z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ka(MemberSettingAuthorityManagePart this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Ma(z16);
    }

    private final void La(boolean isBlacklist) {
        MemberSettingUIModel memberSettingUIModel = this.uiModel;
        us2.a<x.b.d, x.c.g> aVar = null;
        if (memberSettingUIModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel = null;
        }
        if (memberSettingUIModel.getIsFriend()) {
            if (isBlacklist) {
                com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> xVar = this.specialCareConfig;
                if (xVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("specialCareConfig");
                    xVar = null;
                }
                F9(xVar, false);
                com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> xVar2 = this.doNotDisturbConfig;
                if (xVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("doNotDisturbConfig");
                    xVar2 = null;
                }
                F9(xVar2, false);
                us2.a<x.b.d, x.c.g> aVar2 = this.friendIntimateConfig;
                if (aVar2 != null) {
                    if (aVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("friendIntimateConfig");
                    } else {
                        aVar = aVar2;
                    }
                    F9(aVar, false);
                    return;
                }
                return;
            }
            com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> xVar3 = this.specialCareConfig;
            if (xVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("specialCareConfig");
                xVar3 = null;
            }
            F9(xVar3, true);
            com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> xVar4 = this.doNotDisturbConfig;
            if (xVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("doNotDisturbConfig");
                xVar4 = null;
            }
            F9(xVar4, true);
            us2.a<x.b.d, x.c.g> aVar3 = this.friendIntimateConfig;
            if (aVar3 != null) {
                if (aVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("friendIntimateConfig");
                } else {
                    aVar = aVar3;
                }
                F9(aVar, true);
            }
        }
    }

    private final void Ma(boolean checkState) {
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> xVar = this.blacklistConfig;
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> xVar2 = null;
        if (xVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blacklistConfig");
            xVar = null;
        }
        x.c.f O = xVar.O();
        O.h(null);
        O.f(checkState);
        O.h(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.troop.membersetting.part.a
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                MemberSettingAuthorityManagePart.Na(MemberSettingAuthorityManagePart.this, compoundButton, z16);
            }
        });
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> xVar3 = this.blacklistConfig;
        if (xVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blacklistConfig");
        } else {
            xVar2 = xVar3;
        }
        D9(xVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Na(MemberSettingAuthorityManagePart this$0, CompoundButton compoundButton, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ra(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Oa(boolean checkState) {
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> xVar = this.doNotDisturbConfig;
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> xVar2 = null;
        if (xVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("doNotDisturbConfig");
            xVar = null;
        }
        x.c.f O = xVar.O();
        O.h(null);
        O.f(checkState);
        O.h(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.troop.membersetting.part.p
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                MemberSettingAuthorityManagePart.Pa(MemberSettingAuthorityManagePart.this, compoundButton, z16);
            }
        });
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> xVar3 = this.doNotDisturbConfig;
        if (xVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("doNotDisturbConfig");
        } else {
            xVar2 = xVar3;
        }
        D9(xVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Pa(MemberSettingAuthorityManagePart this$0, CompoundButton compoundButton, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sa(z16);
    }

    private final void Qa(int resIcon, String bindName) {
        Drawable mutate;
        us2.a<x.b.d, x.c.g> aVar = null;
        if (bindName != null) {
            us2.a<x.b.d, x.c.g> aVar2 = this.friendIntimateConfig;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("friendIntimateConfig");
                aVar2 = null;
            }
            aVar2.O().h(bindName);
        }
        us2.a<x.b.d, x.c.g> aVar3 = this.friendIntimateConfig;
        if (aVar3 == null) {
            return;
        }
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("friendIntimateConfig");
            aVar3 = null;
        }
        LinearLayout rightContainer = aVar3.getRightContainer();
        if (rightContainer != null) {
            rightContainer.removeAllViews();
        }
        View themeImageView = new ThemeImageView(getActivity().getBaseContext());
        if (resIcon != 0) {
            Drawable drawable = getContext().getResources().getDrawable(resIcon);
            if (drawable instanceof SkinnableBitmapDrawable) {
                mutate = ((SkinnableBitmapDrawable) drawable).mutate2();
            } else {
                mutate = drawable.mutate();
            }
            MemberSettingUIModel memberSettingUIModel = this.uiModel;
            if (memberSettingUIModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                memberSettingUIModel = null;
            }
            if (memberSettingUIModel.getFriendIntimateIsExtinguish()) {
                mutate.setAlpha(102);
            } else {
                mutate.setAlpha(255);
            }
            int i3 = (int) ((21 * getContext().getResources().getDisplayMetrics().density) + 0.5d);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i3);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.f9614);
            themeImageView.setLayoutParams(layoutParams);
            themeImageView.setBackground(mutate);
            us2.a<x.b.d, x.c.g> aVar4 = this.friendIntimateConfig;
            if (aVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("friendIntimateConfig");
                aVar4 = null;
            }
            LinearLayout rightContainer2 = aVar4.getRightContainer();
            if (rightContainer2 != null) {
                rightContainer2.addView(themeImageView);
            }
        }
        us2.a<x.b.d, x.c.g> aVar5 = this.friendIntimateConfig;
        if (aVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("friendIntimateConfig");
        } else {
            aVar = aVar5;
        }
        D9(aVar);
    }

    private final void Ra() {
        if (((IRelationBlacklistApi) QRoute.api(IRelationBlacklistApi.class)).isEnableBlackList()) {
            return;
        }
        MemberSettingUIModel memberSettingUIModel = this.uiModel;
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> xVar = null;
        if (memberSettingUIModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel = null;
        }
        if (memberSettingUIModel.getIsShield()) {
            com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> xVar2 = this.specialCareConfig;
            if (xVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("specialCareConfig");
                xVar2 = null;
            }
            F9(xVar2, false);
            com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> xVar3 = this.doNotDisturbConfig;
            if (xVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("doNotDisturbConfig");
            } else {
                xVar = xVar3;
            }
            F9(xVar, false);
            return;
        }
        MemberSettingUIModel memberSettingUIModel2 = this.uiModel;
        if (memberSettingUIModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel2 = null;
        }
        if (memberSettingUIModel2.getIsFriend()) {
            com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> xVar4 = this.specialCareConfig;
            if (xVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("specialCareConfig");
                xVar4 = null;
            }
            F9(xVar4, true);
            com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> xVar5 = this.doNotDisturbConfig;
            if (xVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("doNotDisturbConfig");
            } else {
                xVar = xVar5;
            }
            F9(xVar, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Sa(boolean isSuccess, boolean isCancelShield) {
        if (((IRelationBlacklistApi) QRoute.api(IRelationBlacklistApi.class)).isEnableBlackList()) {
            return;
        }
        xs2.c.f448459a.e();
        MemberSettingUIModel memberSettingUIModel = this.uiModel;
        MemberSettingUIModel memberSettingUIModel2 = null;
        if (memberSettingUIModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel = null;
        }
        if ((memberSettingUIModel.getOpsFlags() & 2) == 2) {
            if (isSuccess) {
                if (isCancelShield) {
                    QQToast.makeText(getContext(), 2, R.string.f132162o, 0).show();
                } else {
                    QQToast.makeText(getContext(), 2, R.string.f132182q, 0).show();
                }
            } else if (isCancelShield) {
                QQToast.makeText(getContext(), 2, R.string.f132152n, 0).show();
            } else {
                QQToast.makeText(getContext(), 2, R.string.f132172p, 0).show();
            }
        }
        MemberSettingUIModel memberSettingUIModel3 = this.uiModel;
        if (memberSettingUIModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel3 = null;
        }
        MemberSettingUIModel memberSettingUIModel4 = this.uiModel;
        if (memberSettingUIModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel4 = null;
        }
        memberSettingUIModel3.g0(memberSettingUIModel4.getOpsFlags() & (-3));
        MemberSettingUIModel memberSettingUIModel5 = this.uiModel;
        if (memberSettingUIModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
        } else {
            memberSettingUIModel2 = memberSettingUIModel5;
        }
        Ma(memberSettingUIModel2.getIsShield());
        Ra();
    }

    private final void ea(final Activity activity, final String uin, final boolean isCheck) {
        if (com.tencent.relation.common.utils.i.c().b()) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troop.membersetting.part.r
                @Override // java.lang.Runnable
                public final void run() {
                    MemberSettingAuthorityManagePart.ga(uin, this, activity, isCheck);
                }
            });
        } else {
            ((IRelationBlacklistApi) QRoute.api(IRelationBlacklistApi.class)).sendGetShieldListNumberRequest(new RelationBlacklistListener() { // from class: com.tencent.mobileqq.troop.membersetting.part.b
                @Override // com.tencent.mobileqq.profilecard.listener.RelationBlacklistListener
                public final void onResult(boolean z16, Object obj) {
                    MemberSettingAuthorityManagePart.ha(MemberSettingAuthorityManagePart.this, isCheck, uin, activity, z16, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ga(String str, MemberSettingAuthorityManagePart this$0, Activity activity, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        if (str != null) {
            this$0.Ca(activity, false, str, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ha(final MemberSettingAuthorityManagePart this$0, final boolean z16, final String str, final Activity activity, final boolean z17, final Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troop.membersetting.part.d
            @Override // java.lang.Runnable
            public final void run() {
                MemberSettingAuthorityManagePart.ia(z17, this$0, z16, obj, str, activity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ia(boolean z16, MemberSettingAuthorityManagePart this$0, boolean z17, Object obj, String str, Activity activity) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        if (!z16) {
            this$0.Ma(!z17);
            return;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type tencent.im.oidb.cmdBlacklist.RelationBlacklist.CountBlockListRsp");
        RelationBlacklist$CountBlockListRsp relationBlacklist$CountBlockListRsp = (RelationBlacklist$CountBlockListRsp) obj;
        if (str != null) {
            this$0.Ca(activity, relationBlacklist$CountBlockListRsp.count.get() > 0, str, z17);
        }
    }

    private final void ja() {
        MemberSettingUIModel memberSettingUIModel = this.uiModel;
        MemberSettingUIModel memberSettingUIModel2 = null;
        if (memberSettingUIModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel = null;
        }
        if (memberSettingUIModel.getIsFriend()) {
            String string = getContext().getString(R.string.f1319827);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026etting_qvip_special_care)");
            com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> xVar = new com.tencent.mobileqq.widget.listitem.x<>(new x.b.d(string), new x.c.g("", false, false, 6, null));
            xVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.membersetting.part.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MemberSettingAuthorityManagePart.la(MemberSettingAuthorityManagePart.this, view);
                }
            });
            this.specialCareConfig = xVar;
            this.configList.add(xVar);
            MemberSettingUIModel memberSettingUIModel3 = this.uiModel;
            if (memberSettingUIModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                memberSettingUIModel3 = null;
            }
            Ta(memberSettingUIModel3.getIsSpecialCare());
            MemberSettingUIModel memberSettingUIModel4 = this.uiModel;
            if (memberSettingUIModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                memberSettingUIModel4 = null;
            }
            if (memberSettingUIModel4.getFriendIntimateOpen()) {
                String string2 = getContext().getString(R.string.f131530z);
                Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri\u2026ng_Intimate_relationship)");
                x.b.d dVar = new x.b.d(string2);
                x.c.g gVar = new x.c.g("", false, false, 6, null);
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                us2.a<x.b.d, x.c.g> aVar = new us2.a<>(dVar, gVar, context);
                aVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.membersetting.part.k
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        MemberSettingAuthorityManagePart.ma(MemberSettingAuthorityManagePart.this, view);
                    }
                });
                this.friendIntimateConfig = aVar;
                this.configList.add(aVar);
                MemberSettingUIModel memberSettingUIModel5 = this.uiModel;
                if (memberSettingUIModel5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                    memberSettingUIModel5 = null;
                }
                int friendIntimateResIcon = memberSettingUIModel5.getFriendIntimateResIcon();
                MemberSettingUIModel memberSettingUIModel6 = this.uiModel;
                if (memberSettingUIModel6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                    memberSettingUIModel6 = null;
                }
                Qa(friendIntimateResIcon, memberSettingUIModel6.getFriendIntimateBindName());
            }
            String string3 = getContext().getString(R.string.f1315915);
            Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.stri\u2026msg_receive_filter_title)");
            x.b.d dVar2 = new x.b.d(string3);
            MemberSettingUIModel memberSettingUIModel7 = this.uiModel;
            if (memberSettingUIModel7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                memberSettingUIModel7 = null;
            }
            com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> xVar2 = new com.tencent.mobileqq.widget.listitem.x<>(dVar2, new x.c.f(memberSettingUIModel7.getKeyNotDisturb(), new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.troop.membersetting.part.l
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                    MemberSettingAuthorityManagePart.na(MemberSettingAuthorityManagePart.this, compoundButton, z16);
                }
            }));
            this.doNotDisturbConfig = xVar2;
            this.configList.add(xVar2);
        }
        Ia();
        MemberSettingUIModel memberSettingUIModel8 = this.uiModel;
        if (memberSettingUIModel8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel8 = null;
        }
        La(memberSettingUIModel8.getIsBlacklist());
        String string4 = getContext().getString(R.string.f1315612);
        Intrinsics.checkNotNullExpressionValue(string4, "context.getString(R.stri\u2026er_setting_add_blacklist)");
        x.b.d dVar3 = new x.b.d(string4);
        MemberSettingUIModel memberSettingUIModel9 = this.uiModel;
        if (memberSettingUIModel9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
        } else {
            memberSettingUIModel2 = memberSettingUIModel9;
        }
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> xVar3 = new com.tencent.mobileqq.widget.listitem.x<>(dVar3, new x.c.f(memberSettingUIModel2.getIsBlacklist(), new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.troop.membersetting.part.m
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                MemberSettingAuthorityManagePart.oa(MemberSettingAuthorityManagePart.this, compoundButton, z16);
            }
        }));
        this.blacklistConfig = xVar3;
        this.configList.add(xVar3);
        String string5 = getContext().getResources().getString(R.string.f131390l);
        Intrinsics.checkNotNullExpressionValue(string5, "context.resources.getStr\u2026ofile_add_blacklist_tips)");
        Object[] array = this.configList.toArray(new com.tencent.mobileqq.widget.listitem.a[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        com.tencent.mobileqq.widget.listitem.a[] aVarArr = (com.tencent.mobileqq.widget.listitem.a[]) array;
        this.groups = new Group[]{new Group("", string5, (com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(aVarArr, aVarArr.length))};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void la(MemberSettingAuthorityManagePart this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ua();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ma(MemberSettingAuthorityManagePart this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ta();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void na(MemberSettingAuthorityManagePart this$0, CompoundButton compoundButton, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sa(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void oa(MemberSettingAuthorityManagePart this$0, CompoundButton compoundButton, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ra(z16);
    }

    private final void pa() {
        MutableLiveData<zs2.a> obtainUiState = C9().obtainUiState();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<zs2.a, Unit> function1 = new Function1<zs2.a, Unit>() { // from class: com.tencent.mobileqq.troop.membersetting.part.MemberSettingAuthorityManagePart$observeUiState$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(zs2.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(zs2.a aVar) {
                if (aVar instanceof a.SpecialCareUpdate) {
                    MemberSettingAuthorityManagePart.this.Ta(((a.SpecialCareUpdate) aVar).getIsSpecialCare());
                    return;
                }
                if (aVar instanceof a.DoNotDisturbUpdate) {
                    MemberSettingAuthorityManagePart.this.Oa(((a.DoNotDisturbUpdate) aVar).getKeySwitch());
                } else if (aVar instanceof a.ShieldMsgUpdate) {
                    a.ShieldMsgUpdate shieldMsgUpdate = (a.ShieldMsgUpdate) aVar;
                    MemberSettingAuthorityManagePart.this.Sa(shieldMsgUpdate.getIsSuccess(), shieldMsgUpdate.getIsCancelShield());
                }
            }
        };
        obtainUiState.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.membersetting.part.n
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MemberSettingAuthorityManagePart.qa(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void qa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void ra(final boolean isChecked) {
        String str;
        IProfileCardBlacklistService iProfileCardBlacklistService = (IProfileCardBlacklistService) z9().getRuntimeService(IProfileCardBlacklistService.class, "all");
        if (((IRelationBlacklistApi) QRoute.api(IRelationBlacklistApi.class)).isEnableBlackList()) {
            str = ProfileCardBlacklistReportConst.ELEM_ID_EM_ADD_TO_BLACKLIST_SWITCH;
        } else {
            str = ProfileCardBlacklistReportConst.ELEM_ID_EM_BLOCK_USER_SWITCH;
        }
        iProfileCardBlacklistService.reportItemEvent("clck", ProfileCardBlacklistReportConst.PAGE_ID_PG_GROUP_PROFILE_SETTING, str, A9(), new HashMap<String, String>(isChecked) { // from class: com.tencent.mobileqq.troop.membersetting.part.MemberSettingAuthorityManagePart$onBlacklistConfigCheck$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                String str2;
                if (isChecked) {
                    str2 = "1";
                } else {
                    str2 = "2";
                }
                put(ProfileCardBlacklistReportConst.ELEM_PARAM_SWITCH_CLICK, str2);
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ boolean containsKey(Object obj) {
                if (obj == null ? true : obj instanceof String) {
                    return containsKey((String) obj);
                }
                return false;
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ boolean containsValue(Object obj) {
                if (obj == null ? true : obj instanceof String) {
                    return containsValue((String) obj);
                }
                return false;
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ Set<Map.Entry<String, String>> entrySet() {
                return getEntries();
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ /* synthetic */ Object get(Object obj) {
                if (obj == null ? true : obj instanceof String) {
                    return get((String) obj);
                }
                return null;
            }

            public /* bridge */ Set<Map.Entry<String, String>> getEntries() {
                return super.entrySet();
            }

            public /* bridge */ Set<String> getKeys() {
                return super.keySet();
            }

            @Override // java.util.HashMap, java.util.Map
            public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
                return !(obj == null ? true : obj instanceof String) ? obj2 : getOrDefault((String) obj, (String) obj2);
            }

            public /* bridge */ int getSize() {
                return super.size();
            }

            public /* bridge */ Collection<String> getValues() {
                return super.values();
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ Set<String> keySet() {
                return getKeys();
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ /* synthetic */ Object remove(Object obj) {
                if (obj == null ? true : obj instanceof String) {
                    return remove((String) obj);
                }
                return null;
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ int size() {
                return getSize();
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ Collection<String> values() {
                return getValues();
            }

            public /* bridge */ boolean containsKey(String str2) {
                return super.containsKey((Object) str2);
            }

            public /* bridge */ boolean containsValue(String str2) {
                return super.containsValue((Object) str2);
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ String get(Object obj) {
                if (obj == null ? true : obj instanceof String) {
                    return get((String) obj);
                }
                return null;
            }

            public final /* bridge */ String getOrDefault(Object obj, String str2) {
                return !(obj == null ? true : obj instanceof String) ? str2 : getOrDefault((String) obj, str2);
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ String remove(Object obj) {
                if (obj == null ? true : obj instanceof String) {
                    return remove((String) obj);
                }
                return null;
            }

            public /* bridge */ String get(String str2) {
                return (String) super.get((Object) str2);
            }

            public /* bridge */ String getOrDefault(String str2, String str3) {
                return (String) super.getOrDefault((Object) str2, str3);
            }

            public /* bridge */ String remove(String str2) {
                return (String) super.remove((Object) str2);
            }

            @Override // java.util.HashMap, java.util.Map
            public final /* bridge */ boolean remove(Object obj, Object obj2) {
                if (!(obj == null ? true : obj instanceof String)) {
                    return false;
                }
                if (obj2 != null ? obj2 instanceof String : true) {
                    return remove((String) obj, (String) obj2);
                }
                return false;
            }

            public /* bridge */ boolean remove(String str2, String str3) {
                return super.remove((Object) str2, (Object) str3);
            }
        });
        MemberSettingUIModel memberSettingUIModel = null;
        if (((IRelationBlacklistApi) QRoute.api(IRelationBlacklistApi.class)).isEnableBlackList()) {
            if (!NetworkUtil.isNetSupport(getContext())) {
                QQToast.makeText(getContext(), 1, R.string.f131791o, 0).show();
                Ma(!isChecked);
                return;
            }
            if (isChecked) {
                Activity activity = getActivity();
                Intrinsics.checkNotNullExpressionValue(activity, "activity");
                MemberSettingUIModel memberSettingUIModel2 = this.uiModel;
                if (memberSettingUIModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                    memberSettingUIModel2 = null;
                }
                AllInOne allInOne = memberSettingUIModel2.getAllInOne();
                ea(activity, allInOne != null ? allInOne.uin : null, isChecked);
                return;
            }
            MemberSettingUIModel memberSettingUIModel3 = this.uiModel;
            if (memberSettingUIModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                memberSettingUIModel3 = null;
            }
            AllInOne allInOne2 = memberSettingUIModel3.getAllInOne();
            za(allInOne2 != null ? allInOne2.uin : null, isChecked);
            return;
        }
        MemberSettingUIModel memberSettingUIModel4 = this.uiModel;
        if (memberSettingUIModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
        } else {
            memberSettingUIModel = memberSettingUIModel4;
        }
        if (memberSettingUIModel.getIsShield() == isChecked) {
            return;
        }
        Activity activity2 = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity2, "activity");
        Ba(activity2, !isChecked);
    }

    private final void sa(boolean isChecked) {
        AppInterface z95 = z9();
        Intrinsics.checkNotNull(z95, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        QQAppInterface qQAppInterface = (QQAppInterface) z95;
        MemberSettingUIModel memberSettingUIModel = this.uiModel;
        if (memberSettingUIModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel = null;
        }
        AllInOne allInOne = memberSettingUIModel.getAllInOne();
        FriendsStatusUtil.u(qQAppInterface, allInOne != null ? allInOne.uin : null, 0, isChecked ? com.tencent.mobileqq.service.message.e.K0() : 0L, true, false, null, true);
    }

    private final void ta() {
        ReportController.o(z9(), "dc00898", "", "", "0X8009F71", "0X8009F71", 0, 0, "", "", "", "");
        MemberSettingUIModel memberSettingUIModel = this.uiModel;
        MemberSettingUIModel memberSettingUIModel2 = null;
        if (memberSettingUIModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel = null;
        }
        if (TextUtils.isEmpty(memberSettingUIModel.getFriendIntimateBindUrl())) {
            return;
        }
        Intent intent = new Intent(getActivity(), (Class<?>) QQBrowserActivity.class);
        Activity activity = getActivity();
        MemberSettingUIModel memberSettingUIModel3 = this.uiModel;
        if (memberSettingUIModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
        } else {
            memberSettingUIModel2 = memberSettingUIModel3;
        }
        activity.startActivityForResult(intent.putExtra("url", memberSettingUIModel2.getFriendIntimateBindUrl()), 9);
    }

    private final void ua() {
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        fromV2.putBoolean(AppConstants.Preferences.SPECIAL_CARE_CHAT_SETTING, false);
        if (fromV2.getBoolean(AppConstants.Preferences.SPECIAL_CARE_RED_POINT_ONE, false)) {
            fromV2.putBoolean(AppConstants.Preferences.SPECIAL_CARE_RED_POINT_ONE, false).apply();
        }
        Intent intent = new Intent();
        intent.setClassName("com.tencent.mobileqq", QQSpecialCareSettingActivity.class.getName());
        MemberSettingUIModel memberSettingUIModel = this.uiModel;
        if (memberSettingUIModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel = null;
        }
        AllInOne allInOne = memberSettingUIModel.getAllInOne();
        intent.putExtra("key_friend_uin", allInOne != null ? allInOne.uin : null);
        intent.putExtra("key_start_from", 2);
        getActivity().startActivity(intent);
        ReportController.o(z9(), "CliOper", "", "", "0X80050E4", "0X80050E4", 0, 0, "0", "", "", "");
    }

    private final void va(Activity activity, String uin, boolean isCheck) {
        wa(activity, uin, isCheck);
        MemberSettingUIModel memberSettingUIModel = this.uiModel;
        if (memberSettingUIModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel = null;
        }
        if (memberSettingUIModel.getIsTransferShield()) {
            QQToastUtil.showQQToastInUiThread(2, getContext().getString(R.string.f132192r));
            com.tencent.relation.common.utils.i.c().i(true);
            ((IRelationBlacklistApi) QRoute.api(IRelationBlacklistApi.class)).sendShieldListTransferRequest(null);
        }
    }

    private final void wa(final Activity activity, final String uin, final boolean isCheck) {
        ((IRelationBlacklistApi) QRoute.api(IRelationBlacklistApi.class)).sendAddBlacklistRequest(uin, new RelationBlacklistListener() { // from class: com.tencent.mobileqq.troop.membersetting.part.h
            @Override // com.tencent.mobileqq.profilecard.listener.RelationBlacklistListener
            public final void onResult(boolean z16, Object obj) {
                MemberSettingAuthorityManagePart.xa(MemberSettingAuthorityManagePart.this, isCheck, uin, activity, z16, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xa(MemberSettingAuthorityManagePart this$0, boolean z16, String uin, Activity activity, boolean z17, Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(uin, "$uin");
        if (!z17) {
            this$0.Ma(!z16);
            return;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type tencent.im.oidb.cmdBlacklist.RelationBlacklist.BlockRsp");
        RelationBlacklist$BlockRsp relationBlacklist$BlockRsp = (RelationBlacklist$BlockRsp) obj;
        if (relationBlacklist$BlockRsp.code.get() == 0) {
            this$0.La(true);
            ((IProfileCardFeatureApi) QRoute.api(IProfileCardFeatureApi.class)).updateUserIsBlacklistUinFlag(uin, true);
            ((IProfileCardBlacklistService) this$0.z9().getRuntimeService(IProfileCardBlacklistService.class, "all")).deleteBlacklistUinMessage(uin);
        } else if (relationBlacklist$BlockRsp.code.get() == 10001) {
            String str = relationBlacklist$BlockRsp.f436002msg.get();
            Intrinsics.checkNotNullExpressionValue(str, "rsp.msg.get()");
            this$0.Ga(activity, str, z16);
        } else {
            this$0.Ma(!z16);
            String str2 = relationBlacklist$BlockRsp.f436002msg.get();
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            QQToastUtil.showQQToastInUiThread(1, str2);
        }
    }

    private final void za(final String uin, final boolean isCheck) {
        ((IRelationBlacklistApi) QRoute.api(IRelationBlacklistApi.class)).sendDeleteBlacklistRequest(uin, new RelationBlacklistListener() { // from class: com.tencent.mobileqq.troop.membersetting.part.q
            @Override // com.tencent.mobileqq.profilecard.listener.RelationBlacklistListener
            public final void onResult(boolean z16, Object obj) {
                MemberSettingAuthorityManagePart.Aa(MemberSettingAuthorityManagePart.this, uin, isCheck, z16, obj);
            }
        });
    }

    @Override // com.tencent.mobileqq.troop.membersetting.part.t
    /* renamed from: H9, reason: from getter */
    public Group[] getGroups() {
        return this.groups;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        this.uiModel = C9().Q1();
        ja();
        pa();
    }

    private final void Ga(Activity activity, String msg2, final boolean isCheck) {
        RelationDialogUtil.c(activity, 230, getContext().getString(R.string.f131340g), msg2, getContext().getString(R.string.f131330f), "", null, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.membersetting.part.i
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                MemberSettingAuthorityManagePart.Ha(MemberSettingAuthorityManagePart.this, isCheck, dialogInterface, i3);
            }
        });
        ((IProfileCardBlacklistService) z9().getRuntimeService(IProfileCardBlacklistService.class, "all")).reportItemEvent("imp", ProfileCardBlacklistReportConst.PAGE_ID_PG_BLACKLIST_LIMIT_POP, null, new HashMap<String, String>(this) { // from class: com.tencent.mobileqq.troop.membersetting.part.MemberSettingAuthorityManagePart$showBlacklistLimitDialog$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                MemberSettingUIModel memberSettingUIModel;
                memberSettingUIModel = this.uiModel;
                if (memberSettingUIModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                    memberSettingUIModel = null;
                }
                AllInOne allInOne = memberSettingUIModel.getAllInOne();
                put("to_uin", allInOne != null ? allInOne.uin : null);
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ boolean containsKey(Object obj) {
                if (obj == null ? true : obj instanceof String) {
                    return containsKey((String) obj);
                }
                return false;
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ boolean containsValue(Object obj) {
                if (obj == null ? true : obj instanceof String) {
                    return containsValue((String) obj);
                }
                return false;
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ Set<Map.Entry<String, String>> entrySet() {
                return getEntries();
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ /* synthetic */ Object get(Object obj) {
                if (obj == null ? true : obj instanceof String) {
                    return get((String) obj);
                }
                return null;
            }

            public /* bridge */ Set<Map.Entry<String, String>> getEntries() {
                return super.entrySet();
            }

            public /* bridge */ Set<String> getKeys() {
                return super.keySet();
            }

            @Override // java.util.HashMap, java.util.Map
            public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
                return !(obj == null ? true : obj instanceof String) ? obj2 : getOrDefault((String) obj, (String) obj2);
            }

            public /* bridge */ int getSize() {
                return super.size();
            }

            public /* bridge */ Collection<String> getValues() {
                return super.values();
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ Set<String> keySet() {
                return getKeys();
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ /* synthetic */ Object remove(Object obj) {
                if (obj == null ? true : obj instanceof String) {
                    return remove((String) obj);
                }
                return null;
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ int size() {
                return getSize();
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ Collection<String> values() {
                return getValues();
            }

            public /* bridge */ boolean containsKey(String str) {
                return super.containsKey((Object) str);
            }

            public /* bridge */ boolean containsValue(String str) {
                return super.containsValue((Object) str);
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ String get(Object obj) {
                if (obj == null ? true : obj instanceof String) {
                    return get((String) obj);
                }
                return null;
            }

            public final /* bridge */ String getOrDefault(Object obj, String str) {
                return !(obj == null ? true : obj instanceof String) ? str : getOrDefault((String) obj, str);
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ String remove(Object obj) {
                if (obj == null ? true : obj instanceof String) {
                    return remove((String) obj);
                }
                return null;
            }

            public /* bridge */ String get(String str) {
                return (String) super.get((Object) str);
            }

            public /* bridge */ String getOrDefault(String str, String str2) {
                return (String) super.getOrDefault((Object) str, str2);
            }

            public /* bridge */ String remove(String str) {
                return (String) super.remove((Object) str);
            }

            @Override // java.util.HashMap, java.util.Map
            public final /* bridge */ boolean remove(Object obj, Object obj2) {
                if (!(obj == null ? true : obj instanceof String)) {
                    return false;
                }
                if (obj2 != null ? obj2 instanceof String : true) {
                    return remove((String) obj, (String) obj2);
                }
                return false;
            }

            public /* bridge */ boolean remove(String str, String str2) {
                return super.remove((Object) str, (Object) str2);
            }
        }, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ta(boolean isSpecialCare) {
        String string;
        if (isSpecialCare) {
            string = getContext().getResources().getString(R.string.f131861v);
        } else {
            string = getContext().getResources().getString(R.string.f1319423);
        }
        Intrinsics.checkNotNullExpressionValue(string, "if (isSpecialCare) {\n   \u2026ing_not_opened)\n        }");
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> xVar = this.specialCareConfig;
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> xVar2 = null;
        if (xVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("specialCareConfig");
            xVar = null;
        }
        xVar.O().h(string);
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> xVar3 = this.specialCareConfig;
        if (xVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("specialCareConfig");
        } else {
            xVar2 = xVar3;
        }
        D9(xVar2);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Bundle extras;
        Bundle extras2;
        boolean z16 = false;
        if (requestCode == 6 || requestCode == 7) {
            boolean z17 = (data == null || (extras2 = data.getExtras()) == null) ? false : extras2.getBoolean("isSuccess", false);
            if (data != null && (extras = data.getExtras()) != null) {
                z16 = extras.getBoolean("isCancelShield", false);
            }
            Sa(z17, z16);
            return;
        }
        if (requestCode != 9) {
            return;
        }
        AppInterface z95 = z9();
        Intrinsics.checkNotNull(z95, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        QQAppInterface qQAppInterface = (QQAppInterface) z95;
        MemberSettingUIModel memberSettingUIModel = this.uiModel;
        if (memberSettingUIModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel = null;
        }
        AllInOne allInOne = memberSettingUIModel.getAllInOne();
        String str = allInOne != null ? allInOne.uin : null;
        if (str == null) {
            str = "";
        }
        com.tencent.mobileqq.mutualmark.info.c e16 = com.tencent.mobileqq.mutualmark.c.e(qQAppInterface, str, false);
        if (e16 != null) {
            Qa(e16.f252101q, com.tencent.mobileqq.activity.aio.intimate.e.b(getActivity(), e16.f252085a));
        } else {
            Qa(0, "");
        }
    }
}
