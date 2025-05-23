package com.tencent.mobileqq.vas.group;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.data.SmallHomeGroupSettingData;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.zootopia.api.IZootopiaReportApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \"2\u00020\u0001:\u0001#B\u0007\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0004H\u0002J\u001a\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u0004H\u0014R\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/vas/group/SmallHomeGroupSettingFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "", "initView", "", TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, "th", "Lcom/tencent/mobileqq/vas/data/SmallHomeGroupSettingData;", "data", "Ah", "", "troopUin", "Ch", "Eh", "Dh", "Bh", "", "isChecked", "uh", "checked", "switchType", OcrConfig.CHINESE, "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "getContentLayoutId", "Lz23/d;", BdhLogUtil.LogTag.Tag_Conn, "Lz23/d;", "service", "<init>", "()V", "D", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class SmallHomeGroupSettingFragment extends QIphoneTitleBarFragment {
    private static int E;
    private static int F;
    private static int G;
    private static int H;

    /* renamed from: C, reason: from kotlin metadata */
    private final z23.d service = new z23.d();

    private final void Ah(SmallHomeGroupSettingData data) {
        if (data.getEnterSwitch() != 0) {
            E = data.getEnterSwitch();
        }
        if (data.getRankSwitch() != 0) {
            F = data.getRankSwitch();
        }
        if (data.getOnlineSwitch() != 0) {
            G = data.getOnlineSwitch();
        }
        if (data.getAddedSwitch() != 0) {
            H = data.getAddedSwitch();
        }
    }

    private final void Bh(long troopUin, final int r102) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            QLog.e("SmallHomeGroupSettingFragment", 1, "setRankSwitch app is null");
        } else {
            H = r102;
            this.service.g(appInterface, troopUin, r102, new Function2<Integer, String, Unit>() { // from class: com.tencent.mobileqq.vas.group.SmallHomeGroupSettingFragment$setAddedSwitch$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str) {
                    invoke(num.intValue(), str);
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3, String msg2) {
                    Intrinsics.checkNotNullParameter(msg2, "msg");
                    QLog.i("SmallHomeGroupSettingFragment", 1, "setOnlineSwitch " + r102 + " result " + i3 + " " + msg2);
                }
            });
        }
    }

    private final void Ch(long troopUin, final int r132) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            QLog.e("SmallHomeGroupSettingFragment", 1, "setEntrySwitch app is null");
        } else {
            E = r132;
            z23.d.i(this.service, appInterface, troopUin, r132, 0, new Function2<Integer, String, Unit>() { // from class: com.tencent.mobileqq.vas.group.SmallHomeGroupSettingFragment$setEntrySwitch$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str) {
                    invoke(num.intValue(), str);
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3, String msg2) {
                    Intrinsics.checkNotNullParameter(msg2, "msg");
                    QLog.i("SmallHomeGroupSettingFragment", 1, "setEntrySwitch " + r132 + " result " + i3 + " " + msg2);
                }
            }, 8, null);
        }
    }

    private final void Dh(long troopUin, final int r102) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            QLog.e("SmallHomeGroupSettingFragment", 1, "setRankSwitch app is null");
        } else {
            G = r102;
            this.service.j(appInterface, troopUin, r102, new Function2<Integer, String, Unit>() { // from class: com.tencent.mobileqq.vas.group.SmallHomeGroupSettingFragment$setOnlineSwitch$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str) {
                    invoke(num.intValue(), str);
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3, String msg2) {
                    Intrinsics.checkNotNullParameter(msg2, "msg");
                    QLog.i("SmallHomeGroupSettingFragment", 1, "setOnlineSwitch " + r102 + " result " + i3 + " " + msg2);
                }
            });
        }
    }

    private final void Eh(long troopUin, final int r102) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            QLog.e("SmallHomeGroupSettingFragment", 1, "setRankSwitch app is null");
        } else {
            F = r102;
            this.service.k(appInterface, troopUin, r102, new Function2<Integer, String, Unit>() { // from class: com.tencent.mobileqq.vas.group.SmallHomeGroupSettingFragment$setRankSwitch$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str) {
                    invoke(num.intValue(), str);
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3, String msg2) {
                    Intrinsics.checkNotNullParameter(msg2, "msg");
                    QLog.i("SmallHomeGroupSettingFragment", 1, "setRankSwitch " + r102 + " result " + i3 + " " + msg2);
                }
            });
        }
    }

    private final void initView() {
        Intent intent;
        FormSwitchItem formSwitchItem = (FormSwitchItem) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f163592qz0);
        FormSwitchItem formSwitchItem2 = (FormSwitchItem) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f163594qz2);
        FormSwitchItem formSwitchItem3 = (FormSwitchItem) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f163593qz1);
        FormSwitchItem formSwitchItem4 = (FormSwitchItem) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.qyz);
        FragmentActivity activity = getActivity();
        Serializable serializableExtra = (activity == null || (intent = activity.getIntent()) == null) ? null : intent.getSerializableExtra("data");
        final SmallHomeGroupSettingData smallHomeGroupSettingData = serializableExtra instanceof SmallHomeGroupSettingData ? (SmallHomeGroupSettingData) serializableExtra : null;
        if (smallHomeGroupSettingData == null) {
            QLog.e("SmallHomeGroupSettingFragment", 1, "data == null");
            return;
        }
        Ah(smallHomeGroupSettingData);
        formSwitchItem.setVisibility(th(E));
        formSwitchItem2.setVisibility(th(F));
        formSwitchItem3.setVisibility(th(G));
        formSwitchItem4.setVisibility(th(H));
        formSwitchItem.setChecked(E == 1);
        formSwitchItem2.setChecked(F == 1);
        formSwitchItem3.setChecked(G == 1);
        formSwitchItem4.setChecked(H == 1);
        formSwitchItem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.vas.group.a
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                SmallHomeGroupSettingFragment.vh(SmallHomeGroupSettingFragment.this, smallHomeGroupSettingData, compoundButton, z16);
            }
        });
        formSwitchItem2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.vas.group.b
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                SmallHomeGroupSettingFragment.wh(SmallHomeGroupSettingFragment.this, smallHomeGroupSettingData, compoundButton, z16);
            }
        });
        formSwitchItem3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.vas.group.c
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                SmallHomeGroupSettingFragment.xh(SmallHomeGroupSettingFragment.this, smallHomeGroupSettingData, compoundButton, z16);
            }
        });
        formSwitchItem4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.vas.group.d
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                SmallHomeGroupSettingFragment.yh(SmallHomeGroupSettingFragment.this, smallHomeGroupSettingData, compoundButton, z16);
            }
        });
    }

    private final int th(int r16) {
        if (r16 == 0) {
            return 8;
        }
        return 0;
    }

    private final int uh(boolean isChecked) {
        if (isChecked) {
            return 1;
        }
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void vh(SmallHomeGroupSettingFragment this$0, SmallHomeGroupSettingData smallHomeGroupSettingData, CompoundButton compoundButton, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.zh(z16, 0);
        this$0.Ch(smallHomeGroupSettingData.getTroopUin(), this$0.uh(z16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wh(SmallHomeGroupSettingFragment this$0, SmallHomeGroupSettingData smallHomeGroupSettingData, CompoundButton compoundButton, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.zh(z16, 1);
        this$0.Eh(smallHomeGroupSettingData.getTroopUin(), this$0.uh(z16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xh(SmallHomeGroupSettingFragment this$0, SmallHomeGroupSettingData smallHomeGroupSettingData, CompoundButton compoundButton, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.zh(z16, 2);
        this$0.Dh(smallHomeGroupSettingData.getTroopUin(), this$0.uh(z16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void yh(SmallHomeGroupSettingFragment this$0, SmallHomeGroupSettingData smallHomeGroupSettingData, CompoundButton compoundButton, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.zh(z16, 3);
        this$0.Bh(smallHomeGroupSettingData.getTroopUin(), this$0.uh(z16));
    }

    private final void zh(boolean checked, int switchType) {
        HashMap hashMap = new HashMap();
        hashMap.put("zplan_action_type", "click");
        hashMap.put("zplan_btn_switch_status", Integer.valueOf(checked ? 1 : 0));
        hashMap.put("zplan_btn_switch_type", Integer.valueOf(switchType));
        ((IZootopiaReportApi) QRoute.api(IZootopiaReportApi.class)).reportEvent("ev_zplan_group_xiaowo_activation", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f167416d70;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setTitle(getString(R.string.f169749xe1));
        initView();
    }
}
