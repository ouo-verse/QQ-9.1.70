package com.tencent.mobileqq.settings.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.profilecard.base.report.ProfileCardBlacklistReportConst;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.setting.fragment.BaseSettingFragment;
import com.tencent.mobileqq.setting.widget.SettingOverScrollRecyclerView;
import com.tencent.mobileqq.settings.fragment.GuildPermissionFragment;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIDoubleLineListItem;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.QUIListItemStyle;
import com.tencent.mobileqq.widget.listitem.c;
import com.tencent.mobileqq.widget.listitem.w;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.IKernelSettingListener;
import com.tencent.qqnt.kernel.nativeinterface.IKernelSettingService;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession;
import com.tencent.qqnt.kernel.nativeinterface.PrivacySetting;
import com.tencent.qqnt.kernel.nativeinterface.SettingKeyForNum;
import com.tencent.qqnt.kernel.nativeinterface.bp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.app.MobileQQ;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 F2\u00020\u0001:\u0001GB\u0007\u00a2\u0006\u0004\bD\u0010EJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0005H\u0002J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0002J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0010H\u0002J\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\fH\u0002J\u001a\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001e\u001a\u00020\u0002H\u0016R$\u0010&\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0018\u0010)\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\"\u00100\u001a\u00020*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010 \u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00107\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0014\u0010;\u001a\u0002088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u001a\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00100<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010C\u001a\u00020@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010B\u00a8\u0006H"}, d2 = {"Lcom/tencent/mobileqq/settings/fragment/GuildPermissionFragment;", "Lcom/tencent/mobileqq/setting/fragment/BaseSettingFragment;", "", "initData", "", "Lcom/tencent/mobileqq/widget/listitem/Group;", "Jh", "()[Lcom/tencent/mobileqq/widget/listitem/Group;", "Kh", "Lcom/tencent/mobileqq/widget/listitem/w;", "Lcom/tencent/mobileqq/widget/listitem/QUIDoubleLineListItem;", "Mh", "", "status", "Wh", "Qh", "", "isChecked", "Uh", "Lh", "isPgIn", "Ih", "", "eventId", "Hh", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelSettingService;", "J", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelSettingService;", "getSettingService", "()Lcom/tencent/qqnt/kernel/nativeinterface/IKernelSettingService;", "setSettingService", "(Lcom/tencent/qqnt/kernel/nativeinterface/IKernelSettingService;)V", "settingService", "K", "Landroid/view/View;", "guildRecommend", "", "L", "getListenerId", "()J", "setListenerId", "(J)V", "listenerId", "M", "Z", "Sh", "()Z", "Th", "(Z)V", "isFirstExposure", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "N", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "recyclerViewAdapter", "Landroidx/lifecycle/MutableLiveData;", "P", "Landroidx/lifecycle/MutableLiveData;", "isSwitchOn", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelSettingListener;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelSettingListener;", "listener", "<init>", "()V", BdhLogUtil.LogTag.Tag_Req, "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class GuildPermissionFragment extends BaseSettingFragment {

    /* renamed from: J, reason: from kotlin metadata */
    private IKernelSettingService settingService;

    /* renamed from: K, reason: from kotlin metadata */
    private View guildRecommend;

    /* renamed from: L, reason: from kotlin metadata */
    private long listenerId;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean isFirstExposure = true;

    /* renamed from: N, reason: from kotlin metadata */
    private final QUIListItemAdapter recyclerViewAdapter = new QUIListItemAdapter(QUIListItemStyle.Card, false, false, 6, null);

    /* renamed from: P, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> isSwitchOn = new MutableLiveData<>();

    /* renamed from: Q, reason: from kotlin metadata */
    private final IKernelSettingListener listener = new b();

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/settings/fragment/GuildPermissionFragment$b", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelSettingListener;", "Ljava/util/HashMap;", "Lcom/tencent/qqnt/kernel/nativeinterface/SettingKeyForNum;", "", "setting", "", "onNumSettingChanged", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements IKernelSettingListener {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(GuildPermissionFragment this$0, int i3) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.Wh(i3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingListener
        public /* synthetic */ void onBufferSettingChanged(HashMap hashMap) {
            bp.a(this, hashMap);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingListener
        public /* synthetic */ void onCleanCacheProgressChanged(int i3, int i16) {
            bp.b(this, i3, i16);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingListener
        public void onNumSettingChanged(HashMap<SettingKeyForNum, Integer> setting) {
            Integer num;
            Intrinsics.checkNotNullParameter(setting, "setting");
            SettingKeyForNum settingKeyForNum = SettingKeyForNum.KPRIVACYGUILDRECOMMEND;
            if (!setting.containsKey(settingKeyForNum) || (num = setting.get(settingKeyForNum)) == null) {
                return;
            }
            final GuildPermissionFragment guildPermissionFragment = GuildPermissionFragment.this;
            final int intValue = num.intValue();
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.settings.fragment.k
                @Override // java.lang.Runnable
                public final void run() {
                    GuildPermissionFragment.b.b(GuildPermissionFragment.this, intValue);
                }
            });
            if (guildPermissionFragment.getIsFirstExposure()) {
                guildPermissionFragment.Hh("imp", intValue);
                guildPermissionFragment.Th(false);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingListener
        public /* synthetic */ void onPrivacySettingChanged(PrivacySetting privacySetting) {
            bp.d(this, privacySetting);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingListener
        public /* synthetic */ void onStrSettingChanged(HashMap hashMap) {
            bp.e(this, hashMap);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingListener
        public /* synthetic */ void onVerifyInfoChange(int i3) {
            bp.f(this, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Hh(String eventId, int status) {
        HashMap hashMap = new HashMap();
        if (status == 0) {
            status = 1;
        }
        hashMap.put(ProfileCardBlacklistReportConst.ELEM_PARAM_SWITCH_STATUS, Integer.valueOf(status));
        hashMap.put("switch_id", 1);
        if (Intrinsics.areEqual(eventId, "imp_end")) {
            VideoReport.reportEvent("imp_end", this.guildRecommend, hashMap);
        } else {
            ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).reportDtEventManual(this.guildRecommend, "em_bas_permission_notification_switch", eventId, hashMap);
        }
    }

    private final void Ih(boolean isPgIn) {
        String str;
        VideoReport.setPageId(wh(), "pg_bas_channel_dynamic_notification");
        HashMap hashMap = new HashMap();
        hashMap.put("pgid", "pg_bas_channel_dynamic_notification");
        hashMap.put("dt_pgid", "pg_bas_channel_dynamic_notification");
        VideoReport.setPageReportPolicy(wh(), PageReportPolicy.REPORT_NONE);
        if (isPgIn) {
            str = "pgin";
        } else {
            str = "pgout";
        }
        VideoReport.reportEvent(str, wh(), hashMap);
    }

    private final Group Kh() {
        return new Group(Mh());
    }

    private final int Lh(boolean isChecked) {
        if (isChecked) {
            return 1;
        }
        return 2;
    }

    private final w<QUIDoubleLineListItem> Mh() {
        String string = getString(R.string.f1323739);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.setting_recommend_qq_friend)");
        final com.tencent.mobileqq.widget.listitem.c cVar = new com.tencent.mobileqq.widget.listitem.c(new c.a.g(string, "\u52a0\u7684\u9891\u9053\u53ca\u53d1\u8868/\u4e92\u52a8\u5185\u5bb9\u4f1a\u63a8\u8350\u7ed9\u597d\u53cb"), new c.b.C8994b(true, new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.settings.fragment.g
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                GuildPermissionFragment.Nh(GuildPermissionFragment.this, compoundButton, z16);
            }
        }));
        MutableLiveData<Boolean> mutableLiveData = this.isSwitchOn;
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.settings.fragment.GuildPermissionFragment$getNewGuildRecommendConfig$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                QUIListItemAdapter adapter;
                c.b.C8994b O = cVar.O();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                O.e(it.booleanValue());
                SettingOverScrollRecyclerView wh5 = this.wh();
                if (wh5 == null || (adapter = wh5.getAdapter()) == null) {
                    return;
                }
                adapter.l0(cVar);
            }
        };
        mutableLiveData.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.settings.fragment.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildPermissionFragment.Oh(Function1.this, obj);
            }
        });
        cVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.settings.fragment.i
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                GuildPermissionFragment.Ph(GuildPermissionFragment.this, view);
            }
        });
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Nh(GuildPermissionFragment this$0, CompoundButton compoundButton, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Uh(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ph(GuildPermissionFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "view");
        this$0.guildRecommend = view;
    }

    private final void Qh() {
        if (this.settingService != null) {
            ArrayList<SettingKeyForNum> arrayList = new ArrayList<>();
            arrayList.add(SettingKeyForNum.KPRIVACYGUILDRECOMMEND);
            IKernelSettingService iKernelSettingService = this.settingService;
            Intrinsics.checkNotNull(iKernelSettingService);
            iKernelSettingService.getSettingForNum(arrayList, new IOperateCallback() { // from class: com.tencent.mobileqq.settings.fragment.f
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    GuildPermissionFragment.Rh(i3, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Rh(int i3, String str) {
        QLog.i("GuildPermissionFragment", 1, "result: " + i3 + " errMsg: " + str);
    }

    private final void Uh(final boolean isChecked) {
        if (this.settingService != null) {
            HashMap<SettingKeyForNum, Integer> hashMap = new HashMap<>();
            hashMap.put(SettingKeyForNum.KPRIVACYGUILDRECOMMEND, Integer.valueOf(Lh(isChecked)));
            IKernelSettingService iKernelSettingService = this.settingService;
            Intrinsics.checkNotNull(iKernelSettingService);
            iKernelSettingService.setSettingForNum(hashMap, new IOperateCallback() { // from class: com.tencent.mobileqq.settings.fragment.j
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    GuildPermissionFragment.Vh(GuildPermissionFragment.this, isChecked, i3, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Vh(GuildPermissionFragment this$0, boolean z16, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("GuildPermissionFragment", 1, "result: " + i3 + " errMsg: " + str);
        this$0.Hh("clck", this$0.Lh(z16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Wh(int status) {
        this.isSwitchOn.postValue(Boolean.valueOf(status != 2));
    }

    private final void initData() {
        IQQNTWrapperSession wrapperSession = ((IKernelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "")).getWrapperSession();
        IKernelSettingService settingService = wrapperSession != null ? wrapperSession.getSettingService() : null;
        this.settingService = settingService;
        if (settingService != null) {
            Intrinsics.checkNotNull(settingService);
            this.listenerId = settingService.addKernelSettingListener(this.listener);
        }
        SettingOverScrollRecyclerView wh5 = wh();
        if (wh5 != null) {
            QUIListItemAdapter qUIListItemAdapter = this.recyclerViewAdapter;
            Group[] Jh = Jh();
            qUIListItemAdapter.t0((Group[]) Arrays.copyOf(Jh, Jh.length));
            wh5.setAdapter(qUIListItemAdapter);
        }
        Qh();
    }

    /* renamed from: Sh, reason: from getter */
    public final boolean getIsFirstExposure() {
        return this.isFirstExposure;
    }

    public final void Th(boolean z16) {
        this.isFirstExposure = z16;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Hh("imp_end", Lh(Intrinsics.areEqual(this.isSwitchOn.getValue(), Boolean.TRUE)));
        Ih(false);
        IKernelSettingService iKernelSettingService = this.settingService;
        if (iKernelSettingService != null) {
            Intrinsics.checkNotNull(iKernelSettingService);
            iKernelSettingService.removeKernelSettingListener(this.listenerId);
        }
    }

    @Override // com.tencent.mobileqq.setting.fragment.BaseSettingFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Ih(true);
        setTitle("\u9891\u9053\u6743\u9650");
        initData();
    }

    private final Group[] Jh() {
        return new Group[]{Kh()};
    }
}
