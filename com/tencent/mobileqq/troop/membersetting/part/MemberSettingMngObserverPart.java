package com.tencent.mobileqq.troop.membersetting.part;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.LifecycleOwnerKt;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.troop.homework.api.IHWTroopUtilsApi;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mqq.app.Constants;
import org.json.JSONException;
import org.json.JSONObject;
import ys2.MemberSettingUIModel;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0017J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/troop/membersetting/part/MemberSettingMngObserverPart;", "Lcom/tencent/mobileqq/troop/membersetting/part/t;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "Lys2/a;", "e", "Lys2/a;", "uiModel", "Landroid/content/BroadcastReceiver;", "f", "Landroid/content/BroadcastReceiver;", "mReceiver", "<init>", "()V", tl.h.F, "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public class MemberSettingMngObserverPart extends t {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private MemberSettingUIModel uiModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private BroadcastReceiver mReceiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.troop.membersetting.part.MemberSettingMngObserverPart$mReceiver$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            MemberSettingUIModel memberSettingUIModel;
            MemberSettingUIModel memberSettingUIModel2;
            MemberSettingUIModel memberSettingUIModel3;
            MemberSettingUIModel memberSettingUIModel4;
            MemberSettingUIModel memberSettingUIModel5;
            MemberSettingUIModel memberSettingUIModel6;
            MemberSettingUIModel memberSettingUIModel7;
            String stringExtra;
            String stringExtra2;
            MemberSettingUIModel memberSettingUIModel8;
            MemberSettingUIModel memberSettingUIModel9;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            String action = intent.getAction();
            if (action != null) {
                MemberSettingUIModel memberSettingUIModel10 = null;
                switch (action.hashCode()) {
                    case -1872323934:
                        if (action.equals("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT")) {
                            String stringExtra3 = intent.getStringExtra("event");
                            xs2.c cVar = xs2.c.f448459a;
                            memberSettingUIModel = MemberSettingMngObserverPart.this.uiModel;
                            if (memberSettingUIModel == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                                memberSettingUIModel = null;
                            }
                            if (cVar.f(memberSettingUIModel.getTroopUin()) && Intrinsics.areEqual("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT", action) && Intrinsics.areEqual(IHWTroopUtilsApi.HW_TROOP_IDENTITY_CHANGED_EVENT, stringExtra3)) {
                                String stringExtra4 = intent.getStringExtra("data");
                                if (TextUtils.isEmpty(stringExtra4)) {
                                    return;
                                }
                                try {
                                    JSONObject jSONObject = new JSONObject(stringExtra4);
                                    String optString = jSONObject.optString("groupCode");
                                    memberSettingUIModel2 = MemberSettingMngObserverPart.this.uiModel;
                                    if (memberSettingUIModel2 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                                        memberSettingUIModel2 = null;
                                    }
                                    if (TextUtils.equals(memberSettingUIModel2.getTroopUin(), optString)) {
                                        String optString2 = jSONObject.optString("source");
                                        String optString3 = jSONObject.optString("nickName");
                                        if (!Intrinsics.areEqual(optString2, IHWTroopUtilsApi.HOMEWORK_TROOP_PROFILE_SOURCE)) {
                                            memberSettingUIModel3 = MemberSettingMngObserverPart.this.uiModel;
                                            if (memberSettingUIModel3 == null) {
                                                Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                                                memberSettingUIModel3 = null;
                                            }
                                            if (memberSettingUIModel3.getMyRole() != 3) {
                                                memberSettingUIModel4 = MemberSettingMngObserverPart.this.uiModel;
                                                if (memberSettingUIModel4 == null) {
                                                    Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                                                    memberSettingUIModel4 = null;
                                                }
                                                if (memberSettingUIModel4.getMyRole() != 2) {
                                                    memberSettingUIModel5 = MemberSettingMngObserverPart.this.uiModel;
                                                    if (memberSettingUIModel5 == null) {
                                                        Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                                                        memberSettingUIModel5 = null;
                                                    }
                                                    if (memberSettingUIModel5.getCardType() != 0) {
                                                        return;
                                                    }
                                                }
                                            }
                                        }
                                        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(MemberSettingMngObserverPart.this.getPartHost()), null, null, new MemberSettingMngObserverPart$mReceiver$1$onReceive$1(MemberSettingMngObserverPart.this, optString3, null), 3, null);
                                        return;
                                    }
                                    return;
                                } catch (JSONException e16) {
                                    QLog.e("MemberSettingMngObserverPart", 1, "ACTION_WEBVIEW_DISPATCH_EVENT error = " + e16);
                                    return;
                                }
                            }
                            return;
                        }
                        return;
                    case -617549008:
                        if (action.equals("action_donot_disturb_resp")) {
                            String stringExtra5 = intent.getStringExtra("key_uin");
                            memberSettingUIModel6 = MemberSettingMngObserverPart.this.uiModel;
                            if (memberSettingUIModel6 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                                memberSettingUIModel6 = null;
                            }
                            AllInOne allInOne = memberSettingUIModel6.getAllInOne();
                            if (Intrinsics.areEqual(stringExtra5, allInOne != null ? allInOne.uin : null)) {
                                BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(MemberSettingMngObserverPart.this.getPartHost()), null, null, new MemberSettingMngObserverPart$mReceiver$1$onReceive$3(MemberSettingMngObserverPart.this, intent, null), 3, null);
                                return;
                            }
                            return;
                        }
                        return;
                    case -567903764:
                        if (action.equals(ProfileContants.ACTION_SET_REMARK_FOR_PLUGIN)) {
                            String stringExtra6 = intent.getStringExtra("uin");
                            memberSettingUIModel7 = MemberSettingMngObserverPart.this.uiModel;
                            if (memberSettingUIModel7 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                                memberSettingUIModel7 = null;
                            }
                            AllInOne allInOne2 = memberSettingUIModel7.getAllInOne();
                            if (Intrinsics.areEqual(stringExtra6, allInOne2 != null ? allInOne2.uin : null) && intent.getBooleanExtra(ProfileContants.KEY_IS_SUC, false) && (stringExtra = intent.getStringExtra("remark")) != null) {
                                MemberSettingMngObserverPart memberSettingMngObserverPart = MemberSettingMngObserverPart.this;
                                BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(memberSettingMngObserverPart.getPartHost()), null, null, new MemberSettingMngObserverPart$mReceiver$1$onReceive$2$1(memberSettingMngObserverPart, stringExtra, null), 3, null);
                                return;
                            }
                            return;
                        }
                        return;
                    case 792168809:
                        if (action.equals("ACTION_DELETE_FRIEND") && (stringExtra2 = intent.getStringExtra("KEY_DELETE_FRIEND_UIN")) != null) {
                            MemberSettingMngObserverPart memberSettingMngObserverPart2 = MemberSettingMngObserverPart.this;
                            memberSettingUIModel8 = memberSettingMngObserverPart2.uiModel;
                            if (memberSettingUIModel8 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                                memberSettingUIModel8 = null;
                            }
                            AllInOne allInOne3 = memberSettingUIModel8.getAllInOne();
                            if (allInOne3 != null && !TextUtils.isEmpty(stringExtra2) && Intrinsics.areEqual(allInOne3.uin, stringExtra2)) {
                                QQToast.makeText(context, 2, R.string.f131701f, 0).show();
                            }
                            xs2.c cVar2 = xs2.c.f448459a;
                            Activity activity = memberSettingMngObserverPart2.getActivity();
                            Intrinsics.checkNotNullExpressionValue(activity, "activity");
                            memberSettingUIModel9 = memberSettingMngObserverPart2.uiModel;
                            if (memberSettingUIModel9 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                            } else {
                                memberSettingUIModel10 = memberSettingUIModel9;
                            }
                            cVar2.h(activity, memberSettingUIModel10.getResultIntent());
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    };

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        this.uiModel = C9().Q1();
    }

    @Override // com.tencent.mobileqq.troop.membersetting.part.t, com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
        intentFilter.addAction(ProfileContants.ACTION_SET_REMARK_FOR_PLUGIN);
        intentFilter.addAction("action_donot_disturb_resp");
        intentFilter.addAction(FriendListHandler.ACTION_GATHER_RESP);
        intentFilter.addAction("ACTION_DELETE_FRIEND");
        BaseApplication.getContext().registerReceiver(this.mReceiver, intentFilter);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        try {
            BaseApplication.getContext().unregisterReceiver(this.mReceiver);
        } catch (Exception e16) {
            QLog.e("MemberSettingMngObserverPart", 1, "doOnDestroy unregisterReceiver, e:" + e16.getMessage());
        }
    }
}
