package com.tencent.mobileqq.matchfriend.reborn.register.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.matchfriend.reborn.register.part.QQStrangerRegisterBottomPart;
import com.tencent.mobileqq.matchfriend.reborn.register.part.QQStrangerRegisterProfileContentPart;
import com.tencent.mobileqq.matchfriend.reborn.register.part.ad;
import com.tencent.mobileqq.profilecard.api.IProfileDataService;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.trpcprotocol.kuolie.user_info.user_info.userInfo$Birthday;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import v82.b;
import y82.a;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 +2\u00020\u0001:\u0001,B\u0007\u00a2\u0006\u0004\b)\u0010*J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0016J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u000eH\u0016J\u0012\u0010\u0017\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u001a\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u0004H\u0016J$\u0010!\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/register/fragment/QQStrangerRegisterProfileFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Landroid/content/Intent;", "intent", "", "initData", "", "birthdayCode", "", "rh", "qh", "Lcom/tencent/trpcprotocol/kuolie/user_info/user_info/userInfo$Birthday;", "birthday", "ph", "", "needStatusTrans", "needImmersive", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "isWrapContent", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "initWindowStyleAndAnimation", "onFinish", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "Lv82/b;", BdhLogUtil.LogTag.Tag_Conn, "Lv82/b;", "viewModel", "D", "Z", "withAnim", "<init>", "()V", "E", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerRegisterProfileFragment extends QPublicBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private b viewModel;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean withAnim;

    private final void ph(userInfo$Birthday birthday) {
        int i3 = birthday.year.get();
        int i16 = birthday.month.get();
        int i17 = birthday.day.get();
        QLog.i("QQStrangerRegisterProfileFragment", 1, "[checkBirthdayAndSet] year=" + i3 + ", month=" + i16 + ", day=" + i17);
        if (i3 == 0 || i16 == 0 || i17 == 0) {
            QLog.i("QQStrangerRegisterProfileFragment", 1, "[checkBirthdayAndSet] invalid birthday.");
            birthday.year.set(2000);
            birthday.month.set(2);
            birthday.day.set(23);
        }
        b bVar = this.viewModel;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            bVar = null;
        }
        bVar.M1().postValue(birthday);
    }

    private final void qh() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IProfileDataService.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(\n \u2026essConstant.ALL\n        )");
        Card profileCardFromCache = ((IProfileDataService) runtimeService).getProfileCardFromCache(peekAppRuntime.getCurrentUin());
        if (profileCardFromCache == null) {
            QLog.e("QQStrangerRegisterProfileFragment", 1, "initDataWithQQProfile, but profile card is null.");
            return;
        }
        Short valueOf = Short.valueOf(profileCardFromCache.shGender);
        if (!(valueOf.shortValue() != -1)) {
            valueOf = null;
        }
        if (valueOf != null) {
            short shortValue = valueOf.shortValue();
            if (QLog.isDevelopLevel()) {
                QLog.i("QQStrangerRegisterProfileFragment", 1, "[initDataWithQQProfile] gender=" + ((int) shortValue));
            }
            b bVar = this.viewModel;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                bVar = null;
            }
            bVar.P1().postValue(Short.valueOf(shortValue));
        }
        userInfo$Birthday userinfo_birthday = new userInfo$Birthday();
        Long valueOf2 = Long.valueOf(profileCardFromCache.lBirthday);
        Long l3 = (valueOf2.longValue() > 0L ? 1 : (valueOf2.longValue() == 0L ? 0 : -1)) != 0 ? valueOf2 : null;
        if (l3 != null) {
            int[] rh5 = rh((int) l3.longValue());
            userinfo_birthday.year.set(rh5[0]);
            userinfo_birthday.month.set(rh5[1]);
            userinfo_birthday.day.set(rh5[2]);
        }
        ph(userinfo_birthday);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.tencent.mobileqq.matchfriend.reborn.register.part.b());
        arrayList.add(new ad());
        arrayList.add(new QQStrangerRegisterProfileContentPart());
        b bVar = this.viewModel;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            bVar = null;
        }
        arrayList.add(new QQStrangerRegisterBottomPart(bVar));
        return arrayList;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        Intent intent;
        super.initWindowStyleAndAnimation(activity);
        boolean booleanExtra = (activity == null || (intent = activity.getIntent()) == null) ? false : intent.getBooleanExtra("key_with_anim", false);
        this.withAnim = booleanExtra;
        if (booleanExtra || activity == null) {
            return;
        }
        activity.overridePendingTransition(0, 0);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return true;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewModel viewModel = getViewModel(b.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QQStrangerR\u2026terProfileVM::class.java)");
        this.viewModel = (b) viewModel;
        initData(getQBaseActivity().getIntent());
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Map mutableMapOf;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View rootView = inflater.inflate(R.layout.f167366cy0, container, false);
        b bVar = this.viewModel;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            bVar = null;
        }
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("member_type", Integer.valueOf(bVar.getIsNewUser() ? 1 : 2)), TuplesKt.to("select_page_type", 1));
        a.b().c(getActivity(), rootView, "pg_bas_expand_first_registration", new PageParams((Map<String, ?>) mutableMapOf));
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        return rootView;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        FragmentActivity activity;
        super.onFinish();
        if (this.withAnim || (activity = getActivity()) == null) {
            return;
        }
        activity.overridePendingTransition(0, 0);
    }

    private final int[] rh(int birthdayCode) {
        return new int[]{((-65536) & birthdayCode) >>> 16, (65280 & birthdayCode) >>> 8, birthdayCode & 255};
    }

    private final void initData(Intent intent) {
        if (intent == null) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.setResult(0);
                activity.finish();
                return;
            }
            return;
        }
        b bVar = this.viewModel;
        b bVar2 = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            bVar = null;
        }
        String stringExtra = intent.getStringExtra("key_open_id");
        if (stringExtra == null) {
            stringExtra = "";
        }
        bVar.a2(stringExtra);
        b bVar3 = this.viewModel;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            bVar3 = null;
        }
        bVar3.X1(intent.getBooleanExtra("key_is_new_user", true));
        b bVar4 = this.viewModel;
        if (bVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            bVar4 = null;
        }
        String openId = bVar4.getOpenId();
        b bVar5 = this.viewModel;
        if (bVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            bVar5 = null;
        }
        QLog.i("QQStrangerRegisterProfileFragment", 1, "initData openId=" + openId + ", isNewUser=" + bVar5.getIsNewUser());
        b bVar6 = this.viewModel;
        if (bVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            bVar6 = null;
        }
        if (bVar6.getOpenId().length() == 0) {
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                activity2.setResult(0);
                activity2.finish();
                return;
            }
            return;
        }
        b bVar7 = this.viewModel;
        if (bVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            bVar2 = bVar7;
        }
        bVar2.O1().postValue("\u4e0b\u4e00\u6b65");
        qh();
    }
}
