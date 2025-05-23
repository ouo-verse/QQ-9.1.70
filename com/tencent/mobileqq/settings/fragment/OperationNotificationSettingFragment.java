package com.tencent.mobileqq.settings.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.guildtab.IGuildUserService;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.profilecard.base.report.ProfileCardBlacklistReportConst;
import com.tencent.mobileqq.profilecommon.processor.QZoneSwitchProcessor;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.QUISettingsRecyclerView;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.IKernelSettingListener;
import com.tencent.qqnt.kernel.nativeinterface.IKernelSettingService;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession;
import com.tencent.qqnt.kernel.nativeinterface.PrivacySetting;
import com.tencent.qqnt.kernel.nativeinterface.SettingKeyForNum;
import com.tencent.qqnt.kernel.nativeinterface.bp;
import com.tencent.relation.common.handler.IntimateNotificationSwitchProcessor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 h2\u00020\u0001:\u0001iB\u0007\u00a2\u0006\u0004\bf\u0010gJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\fH\u0002J0\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000fH\u0002J&\u0010!\u001a\u00020\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0014J\u0006\u0010\"\u001a\u00020\u0002J\b\u0010#\u001a\u00020\u0002H\u0016J$\u0010(\u001a\u00020\u00022\u0014\u0010'\u001a\u0010\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&\u0018\u00010$2\u0006\u0010\u0017\u001a\u00020\u000fJ\b\u0010)\u001a\u00020\u000fH\u0014R$\u00101\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00109\u001a\u0002028\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R$\u0010A\u001a\u0004\u0018\u00010:8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R0\u0010H\u001a\u0010\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&\u0018\u00010$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR0\u0010L\u001a\u0010\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&\u0018\u00010$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bI\u0010C\u001a\u0004\bJ\u0010E\"\u0004\bK\u0010GR0\u0010P\u001a\u0010\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&\u0018\u00010$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bM\u0010C\u001a\u0004\bN\u0010E\"\u0004\bO\u0010GR0\u0010T\u001a\u0010\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&\u0018\u00010$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bQ\u0010C\u001a\u0004\bR\u0010E\"\u0004\bS\u0010GR\"\u0010[\u001a\u00020U8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bV\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\"\u0010^\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u0014\u0010e\u001a\u00020b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bc\u0010d\u00a8\u0006j"}, d2 = {"Lcom/tencent/mobileqq/settings/fragment/OperationNotificationSettingFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "", "Ih", "", "eventId", "Fh", "Lcom/tencent/mobileqq/widget/listitem/Group;", "xh", "Gh", "Lcom/tencent/qqnt/kernel/nativeinterface/SettingKeyForNum;", "keyForNum", "", "isChecked", "Oh", "", "originIndex", "Ah", "Dh", "isPgIn", OcrConfig.CHINESE, "Landroid/view/View;", "view", "status", "switchId", "position", "yh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "doOnCreateView", "initData", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/activity/newsetting/custom/config/b;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c;", DownloadInfo.spKey_Config, "Qh", "getContentLayoutId", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "getAdapter", "()Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "setAdapter", "(Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;)V", "adapter", "Lcom/tencent/mobileqq/widget/listitem/QUISettingsRecyclerView;", "D", "Lcom/tencent/mobileqq/widget/listitem/QUISettingsRecyclerView;", "Eh", "()Lcom/tencent/mobileqq/widget/listitem/QUISettingsRecyclerView;", "Nh", "(Lcom/tencent/mobileqq/widget/listitem/QUISettingsRecyclerView;)V", "recyclerView", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelSettingService;", "E", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelSettingService;", "getSettingService", "()Lcom/tencent/qqnt/kernel/nativeinterface/IKernelSettingService;", "setSettingService", "(Lcom/tencent/qqnt/kernel/nativeinterface/IKernelSettingService;)V", "settingService", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/activity/newsetting/custom/config/b;", "Ch", "()Lcom/tencent/mobileqq/activity/newsetting/custom/config/b;", "setGuildConfig", "(Lcom/tencent/mobileqq/activity/newsetting/custom/config/b;)V", "guildConfig", "G", "Bh", "setGameCenterConfig", "gameCenterConfig", "H", "getQzoneConfig", "setQzoneConfig", "qzoneConfig", "I", "getIntimateConfig", "setIntimateConfig", "intimateConfig", "", "J", "getListenerId", "()J", "setListenerId", "(J)V", "listenerId", "K", "Z", "isGuildUser", "()Z", "setGuildUser", "(Z)V", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelSettingListener;", "L", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelSettingListener;", "listener", "<init>", "()V", "M", "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class OperationNotificationSettingFragment extends QIphoneTitleBarFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private QUIListItemAdapter adapter;

    /* renamed from: D, reason: from kotlin metadata */
    public QUISettingsRecyclerView recyclerView;

    /* renamed from: E, reason: from kotlin metadata */
    private IKernelSettingService settingService;

    /* renamed from: F, reason: from kotlin metadata */
    private com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b.d, x.c> guildConfig;

    /* renamed from: G, reason: from kotlin metadata */
    private com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b.d, x.c> gameCenterConfig;

    /* renamed from: H, reason: from kotlin metadata */
    private com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b.d, x.c> qzoneConfig;

    /* renamed from: I, reason: from kotlin metadata */
    private com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b.d, x.c> intimateConfig;

    /* renamed from: J, reason: from kotlin metadata */
    private long listenerId;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean isGuildUser;

    /* renamed from: L, reason: from kotlin metadata */
    private final IKernelSettingListener listener = new c();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JP\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/settings/fragment/OperationNotificationSettingFragment$b", "Landroid/view/View$OnLayoutChangeListener;", "Landroid/view/View;", "view", "", "left", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "", "onLayoutChange", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements View.OnLayoutChangeListener {
        b() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
            Intrinsics.checkNotNullParameter(view, "view");
            OperationNotificationSettingFragment.this.Fh("imp");
            OperationNotificationSettingFragment.this.Eh().removeOnLayoutChangeListener(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\b\u001a\u00020\u00072\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/settings/fragment/OperationNotificationSettingFragment$c", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelSettingListener;", "Ljava/util/HashMap;", "Lcom/tencent/qqnt/kernel/nativeinterface/SettingKeyForNum;", "", "Lkotlin/collections/HashMap;", "setting", "", "onNumSettingChanged", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements IKernelSettingListener {

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes35.dex */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f286823a;

            static {
                int[] iArr = new int[SettingKeyForNum.values().length];
                try {
                    iArr[SettingKeyForNum.KTIANSHUHMSGGUILD.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[SettingKeyForNum.KTIANSHUHMSGGAMECENTER.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f286823a = iArr;
            }
        }

        c() {
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
            Intrinsics.checkNotNullParameter(setting, "setting");
            QLog.i("OperationNotificationSettingFragment", 1, "IKernelSettingListener onNumSettingChanged  " + setting + " ");
            for (Map.Entry<SettingKeyForNum, Integer> entry : setting.entrySet()) {
                SettingKeyForNum key = entry.getKey();
                int intValue = entry.getValue().intValue();
                int i3 = a.f286823a[key.ordinal()];
                if (i3 == 1) {
                    OperationNotificationSettingFragment operationNotificationSettingFragment = OperationNotificationSettingFragment.this;
                    operationNotificationSettingFragment.Qh(operationNotificationSettingFragment.Ch(), intValue);
                } else if (i3 == 2) {
                    OperationNotificationSettingFragment operationNotificationSettingFragment2 = OperationNotificationSettingFragment.this;
                    operationNotificationSettingFragment2.Qh(operationNotificationSettingFragment2.Bh(), intValue);
                }
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

    private final int Ah(int originIndex) {
        return this.isGuildUser ? originIndex : originIndex - 1;
    }

    private final int Dh(boolean isChecked) {
        if (isChecked) {
            return 1;
        }
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Fh(String eventId) {
        if (this.isGuildUser) {
            View childAt = Eh().getChildAt(0);
            if (childAt == null) {
                childAt = Eh();
            }
            View view = childAt;
            com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b.d, x.c> bVar = this.guildConfig;
            Intrinsics.checkNotNull(bVar);
            yh(view, eventId, Dh(bVar.W()), 1, 1);
        }
        View childAt2 = Eh().getChildAt(Ah(1));
        if (childAt2 == null) {
            childAt2 = Eh();
        }
        View view2 = childAt2;
        com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b.d, x.c> bVar2 = this.gameCenterConfig;
        Intrinsics.checkNotNull(bVar2);
        yh(view2, eventId, Dh(bVar2.W()), 2, Ah(2));
        View childAt3 = Eh().getChildAt(Ah(2));
        if (childAt3 == null) {
            childAt3 = Eh();
        }
        View view3 = childAt3;
        com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b.d, x.c> bVar3 = this.qzoneConfig;
        Intrinsics.checkNotNull(bVar3);
        yh(view3, eventId, Dh(bVar3.W()), 3, Ah(3));
    }

    private final void Gh() {
        if (this.settingService != null) {
            ArrayList<SettingKeyForNum> arrayList = new ArrayList<>();
            arrayList.add(SettingKeyForNum.KTIANSHUHMSGGUILD);
            arrayList.add(SettingKeyForNum.KTIANSHUHMSGGAMECENTER);
            IKernelSettingService iKernelSettingService = this.settingService;
            Intrinsics.checkNotNull(iKernelSettingService);
            iKernelSettingService.getSettingForNum(arrayList, new IOperateCallback() { // from class: com.tencent.mobileqq.settings.fragment.l
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    OperationNotificationSettingFragment.Hh(i3, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Hh(int i3, String str) {
        QLog.i("OperationNotificationSettingFragment", 1, "getSettingForNum result: " + i3 + " errMsg: " + str);
    }

    private final void Ih() {
        com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b.d, x.c> bVar = this.guildConfig;
        if (bVar != null) {
            bVar.e0(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.settings.fragment.m
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                    OperationNotificationSettingFragment.Jh(OperationNotificationSettingFragment.this, compoundButton, z16);
                }
            });
        }
        com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b.d, x.c> bVar2 = this.gameCenterConfig;
        if (bVar2 != null) {
            bVar2.e0(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.settings.fragment.n
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                    OperationNotificationSettingFragment.Kh(OperationNotificationSettingFragment.this, compoundButton, z16);
                }
            });
        }
        com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b.d, x.c> bVar3 = this.qzoneConfig;
        if (bVar3 != null) {
            bVar3.e0(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.settings.fragment.o
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                    OperationNotificationSettingFragment.Lh(OperationNotificationSettingFragment.this, compoundButton, z16);
                }
            });
        }
        com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b.d, x.c> bVar4 = this.intimateConfig;
        if (bVar4 != null) {
            bVar4.e0(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.settings.fragment.p
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                    OperationNotificationSettingFragment.Mh(compoundButton, z16);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Jh(OperationNotificationSettingFragment this$0, CompoundButton buttonView, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Oh(SettingKeyForNum.KTIANSHUHMSGGUILD, z16);
        VideoReport.setElementClickPolicy(buttonView, ClickPolicy.REPORT_NONE);
        Intrinsics.checkNotNullExpressionValue(buttonView, "buttonView");
        this$0.yh(buttonView, "clck", this$0.Dh(z16), 1, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Kh(OperationNotificationSettingFragment this$0, CompoundButton buttonView, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Oh(SettingKeyForNum.KTIANSHUHMSGGAMECENTER, z16);
        VideoReport.setElementClickPolicy(buttonView, ClickPolicy.REPORT_NONE);
        Intrinsics.checkNotNullExpressionValue(buttonView, "buttonView");
        this$0.yh(buttonView, "clck", this$0.Dh(z16), 2, this$0.Ah(2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Lh(OperationNotificationSettingFragment this$0, CompoundButton buttonView, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QZoneSwitchProcessor.c(MobileQQ.sMobileQQ.peekAppRuntime(), z16);
        VideoReport.setElementClickPolicy(buttonView, ClickPolicy.REPORT_NONE);
        Intrinsics.checkNotNullExpressionValue(buttonView, "buttonView");
        this$0.yh(buttonView, "clck", this$0.Dh(z16), 3, this$0.Ah(3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Mh(CompoundButton compoundButton, boolean z16) {
        IntimateNotificationSwitchProcessor.c(MobileQQ.sMobileQQ.peekAppRuntime(), z16);
    }

    private final void Oh(final SettingKeyForNum keyForNum, boolean isChecked) {
        if (this.settingService != null) {
            HashMap<SettingKeyForNum, Integer> hashMap = new HashMap<>();
            hashMap.put(keyForNum, Integer.valueOf(Dh(isChecked)));
            IKernelSettingService iKernelSettingService = this.settingService;
            Intrinsics.checkNotNull(iKernelSettingService);
            iKernelSettingService.setSettingForNum(hashMap, new IOperateCallback() { // from class: com.tencent.mobileqq.settings.fragment.q
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    OperationNotificationSettingFragment.Ph(SettingKeyForNum.this, i3, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ph(SettingKeyForNum keyForNum, int i3, String str) {
        Intrinsics.checkNotNullParameter(keyForNum, "$keyForNum");
        QLog.i("OperationNotificationSettingFragment", 1, "setStatus  " + keyForNum + " result: " + i3 + " errMsg: " + str);
    }

    private final Group xh() {
        String string = getString(R.string.f1323436);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.setting_msg_guild)");
        this.guildConfig = new com.tencent.mobileqq.activity.newsetting.custom.config.b<>(new x.b.d(string), new x.c.f(true, null), this.adapter);
        String string2 = getString(R.string.f1323335);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.setting_msg_game_center)");
        this.gameCenterConfig = new com.tencent.mobileqq.activity.newsetting.custom.config.b<>(new x.b.d(string2), new x.c.f(true, null), this.adapter);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String string3 = getString(R.string.f1323638);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(R.string.setting_qq_zone)");
        this.qzoneConfig = new com.tencent.mobileqq.activity.newsetting.custom.config.b<>(new x.b.d(string3), new x.c.f(peekAppRuntime == null || QZoneSwitchProcessor.a(peekAppRuntime.getCurrentUin()) > 0, null), this.adapter);
        String string4 = getString(R.string.f1323133);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(R.string.setting_intimate_notification)");
        this.intimateConfig = new com.tencent.mobileqq.activity.newsetting.custom.config.b<>(new x.b.d(string4), new x.c.f(peekAppRuntime == null ? true : IntimateNotificationSwitchProcessor.a(peekAppRuntime.getCurrentUin()), null), this.adapter);
        if (this.isGuildUser) {
            String string5 = getString(R.string.f1323234);
            Intrinsics.checkNotNullExpressionValue(string5, "getString(R.string.setti\u2026notification_description)");
            com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b.d, x.c> bVar = this.guildConfig;
            Intrinsics.checkNotNull(bVar);
            com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b.d, x.c> bVar2 = this.gameCenterConfig;
            Intrinsics.checkNotNull(bVar2);
            com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b.d, x.c> bVar3 = this.qzoneConfig;
            Intrinsics.checkNotNull(bVar3);
            com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b.d, x.c> bVar4 = this.intimateConfig;
            Intrinsics.checkNotNull(bVar4);
            return new Group("", string5, bVar, bVar2, bVar3, bVar4);
        }
        String string6 = getString(R.string.f1323234);
        Intrinsics.checkNotNullExpressionValue(string6, "getString(R.string.setti\u2026notification_description)");
        com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b.d, x.c> bVar5 = this.gameCenterConfig;
        Intrinsics.checkNotNull(bVar5);
        com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b.d, x.c> bVar6 = this.qzoneConfig;
        Intrinsics.checkNotNull(bVar6);
        com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b.d, x.c> bVar7 = this.intimateConfig;
        Intrinsics.checkNotNull(bVar7);
        return new Group("", string6, bVar5, bVar6, bVar7);
    }

    private final void yh(View view, String eventId, int status, int switchId, int position) {
        HashMap hashMap = new HashMap();
        if (status == 0) {
            status = 1;
        }
        hashMap.put(ProfileCardBlacklistReportConst.ELEM_PARAM_SWITCH_STATUS, Integer.valueOf(status));
        hashMap.put("switch_id", Integer.valueOf(switchId));
        hashMap.put("switch_position", Integer.valueOf(position));
        VideoReport.setElementId(view, "em_bas_permission_notification_switch");
        if (Intrinsics.areEqual(eventId, "imp_end")) {
            VideoReport.reportEvent("imp_end", view, hashMap);
        } else {
            ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).reportDtEventManual(view, "em_bas_permission_notification_switch", eventId, hashMap);
        }
    }

    private final void zh(boolean isPgIn) {
        String str;
        VideoReport.setPageId(((QIphoneTitleBarFragment) this).mContentView, "pg_bas_friend_dynamic_notification");
        HashMap hashMap = new HashMap();
        hashMap.put("pgid", "pg_bas_friend_dynamic_notification");
        VideoReport.setPageReportPolicy(((QIphoneTitleBarFragment) this).mContentView, PageReportPolicy.REPORT_NONE);
        if (isPgIn) {
            str = "pgin";
        } else {
            str = "pgout";
        }
        VideoReport.reportEvent(str, ((QIphoneTitleBarFragment) this).mContentView, hashMap);
    }

    public final com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b.d, x.c> Bh() {
        return this.gameCenterConfig;
    }

    public final com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b.d, x.c> Ch() {
        return this.guildConfig;
    }

    public final QUISettingsRecyclerView Eh() {
        QUISettingsRecyclerView qUISettingsRecyclerView = this.recyclerView;
        if (qUISettingsRecyclerView != null) {
            return qUISettingsRecyclerView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        return null;
    }

    public final void Nh(QUISettingsRecyclerView qUISettingsRecyclerView) {
        Intrinsics.checkNotNullParameter(qUISettingsRecyclerView, "<set-?>");
        this.recyclerView = qUISettingsRecyclerView;
    }

    public final void Qh(final com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b.d, x.c> config, final int status) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.settings.fragment.r
            @Override // java.lang.Runnable
            public final void run() {
                OperationNotificationSettingFragment.Rh(status, config);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.doOnCreateView(inflater, container, savedInstanceState);
        zh(true);
        setTitle(getString(R.string.f1323537));
        initData();
        Gh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f1272809;
    }

    public final void initData() {
        IQQNTWrapperSession wrapperSession = ((IKernelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "")).getWrapperSession();
        this.settingService = wrapperSession != null ? wrapperSession.getSettingService() : null;
        this.isGuildUser = ((IGuildUserService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGuildUserService.class, "")).isGuildTabSetting();
        IKernelSettingService iKernelSettingService = this.settingService;
        if (iKernelSettingService != null) {
            Intrinsics.checkNotNull(iKernelSettingService);
            this.listenerId = iKernelSettingService.addKernelSettingListener(this.listener);
        }
        View findViewById = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f17911k);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mContentView.findViewByI\u2026ration_notification_view)");
        Nh((QUISettingsRecyclerView) findViewById);
        this.adapter = new QUIListItemAdapter(null, false, false, 7, null);
        Eh().setAdapter(this.adapter);
        Group xh5 = xh();
        QUIListItemAdapter qUIListItemAdapter = this.adapter;
        Intrinsics.checkNotNull(qUIListItemAdapter);
        qUIListItemAdapter.t0(xh5);
        Ih();
        Eh().addOnLayoutChangeListener(new b());
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Fh("imp_end");
        zh(false);
        IKernelSettingService iKernelSettingService = this.settingService;
        if (iKernelSettingService != null) {
            Intrinsics.checkNotNull(iKernelSettingService);
            iKernelSettingService.removeKernelSettingListener(this.listenerId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Rh(int i3, com.tencent.mobileqq.activity.newsetting.custom.config.b bVar) {
        boolean z16 = i3 != 2;
        if (bVar != null) {
            bVar.a0(z16);
        }
    }
}
