package com.tencent.mobileqq.nearbypro.chats.part;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.nearbypro.chats.event.NBPClearInteractiveRedNumberEvent;
import com.tencent.mobileqq.nearbypro.chats.part.ChatsListTitlePart;
import com.tencent.mobileqq.nearbypro.entry.api.INearbyProEntryUnreadMgr;
import com.tencent.mobileqq.nearbypro.entry.api.INearbyProEntryUnreadService;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/chats/part/ChatsListTitlePart;", "Lcom/tencent/mobileqq/nearbypro/chats/part/a;", "Landroid/view/View;", "titleRoot", "", "H9", "", "actionType", "btnType", "G9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "<init>", "()V", "f", "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class ChatsListTitlePart extends a {

    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", NodeProps.ON_CLICK}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes15.dex */
    static final class c implements DialogInterface.OnClickListener {
        /* JADX INFO: Access modifiers changed from: package-private */
        public c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i3) {
            ChatsListTitlePart.this.G9("click", "0");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G9(String actionType, String btnType) {
        Integer num;
        Intent intent;
        HashMap hashMap = new HashMap();
        Activity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null) {
            num = Integer.valueOf(intent.getIntExtra("open_chats_list_source", 0));
        } else {
            num = null;
        }
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        if (btnType == null) {
            btnType = "";
        }
        hashMap.put("nearby_btn_type", btnType);
        hashMap.put("nearby_action_type", actionType);
        hashMap.put("nearby_msg_list_source", String.valueOf(num));
        VideoReport.reportEvent("ev_nearby_clear_confirm_pop", hashMap);
    }

    private final void H9(View titleRoot) {
        ViewGroup.LayoutParams layoutParams;
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            int statusBarHeight = ImmersiveUtils.getStatusBarHeight(getContext());
            j.c().e("ChatsListTitlePart", "onInitView statusBarHeight=" + statusBarHeight);
            ViewGroup.MarginLayoutParams marginLayoutParams = null;
            if (titleRoot != null) {
                layoutParams = titleRoot.getLayoutParams();
            } else {
                layoutParams = null;
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            }
            if (marginLayoutParams == null) {
                marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
            }
            marginLayoutParams.topMargin = statusBarHeight;
            if (titleRoot != null) {
                titleRoot.setLayoutParams(marginLayoutParams);
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        super.onInitView(rootView);
        final xa2.e g16 = xa2.e.g(xv3.a.a(A9().getRoot()), A9().getTopbarContainer(), true);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(\n            lay\u2026           true\n        )");
        H9(g16.getRoot());
        final ImageView imageView = g16.f447587b;
        Intrinsics.checkNotNullExpressionValue(imageView, "titlebar.backIv");
        final long j3 = 200;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.nearbypro.chats.part.ChatsListTitlePart$onInitView$$inlined$setSingleClickListener$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View it) {
                EventCollector.getInstance().onViewClickedBefore(it);
                imageView.setClickable(false);
                Intrinsics.checkNotNullExpressionValue(it, "it");
                Activity activity = this.getActivity();
                if (activity != null) {
                    activity.onBackPressed();
                }
                final View view = imageView;
                view.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.nearbypro.chats.part.ChatsListTitlePart$onInitView$$inlined$setSingleClickListener$1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        view.setClickable(true);
                    }
                }, j3);
                EventCollector.getInstance().onViewClicked(it);
            }
        });
        final ImageView imageView2 = g16.f447588c;
        Intrinsics.checkNotNullExpressionValue(imageView2, "titlebar.notificationIv");
        final long j16 = 200;
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.nearbypro.chats.part.ChatsListTitlePart$onInitView$$inlined$setSingleClickListener$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View it) {
                EventCollector.getInstance().onViewClickedBefore(it);
                imageView2.setClickable(false);
                Intrinsics.checkNotNullExpressionValue(it, "it");
                Activity activity = this.getActivity();
                if (activity != null) {
                    Intrinsics.checkNotNullExpressionValue(activity, "activity ?: return@setSingleClickListener");
                    DialogUtil.createCenterTextDialog(activity, 0, null, this.getActivity().getResources().getString(R.string.f169972js), this.getActivity().getResources().getString(R.string.cancel), this.getActivity().getResources().getString(R.string.f171151ok), new ChatsListTitlePart.b(), new ChatsListTitlePart.c()).show();
                    com.tencent.mobileqq.nearbypro.aio.utils.a.f253152a.a(g16.f447588c, "em_nearby_clear_btn", null);
                    this.G9("imp", null);
                }
                final View view = imageView2;
                view.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.nearbypro.chats.part.ChatsListTitlePart$onInitView$$inlined$setSingleClickListener$2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        view.setClickable(true);
                    }
                }, j16);
                EventCollector.getInstance().onViewClicked(it);
            }
        });
        com.tencent.mobileqq.nearbypro.aio.utils.a.f253152a.b(g16.f447588c, "em_nearby_clear_btn", null);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", NodeProps.ON_CLICK}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes15.dex */
    static final class b implements DialogInterface.OnClickListener {
        /* JADX INFO: Access modifiers changed from: package-private */
        public b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i3) {
            INearbyProEntryUnreadService iNearbyProEntryUnreadService;
            INearbyProEntryUnreadMgr iNearbyProEntryUnreadMgr;
            INearbyProEntryUnreadService iNearbyProEntryUnreadService2;
            IKernelService iKernelService;
            w msgService;
            SimpleEventBus.getInstance().dispatchEvent(new NBPClearInteractiveRedNumberEvent());
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null && (iKernelService = (IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")) != null && (msgService = iKernelService.getMsgService()) != null) {
                msgService.setMsgReadByChatType(119, a.f253268a);
            }
            AppRuntime peekAppRuntime2 = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime2 != null && (iNearbyProEntryUnreadService2 = (INearbyProEntryUnreadService) peekAppRuntime2.getRuntimeService(INearbyProEntryUnreadService.class, "")) != null) {
                iNearbyProEntryUnreadService2.clearTianShuRedPoint();
            }
            AppRuntime peekAppRuntime3 = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime3 != null && (iNearbyProEntryUnreadMgr = (INearbyProEntryUnreadMgr) peekAppRuntime3.getRuntimeService(INearbyProEntryUnreadMgr.class, "")) != null) {
                iNearbyProEntryUnreadMgr.clearUnreadInteractCnt();
            }
            AppRuntime peekAppRuntime4 = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime4 != null && (iNearbyProEntryUnreadService = (INearbyProEntryUnreadService) peekAppRuntime4.getRuntimeService(INearbyProEntryUnreadService.class, "")) != null) {
                iNearbyProEntryUnreadService.clearEntryUnreadInteractCnt();
            }
            ChatsListTitlePart.this.G9("click", "1");
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "", "kotlin.jvm.PlatformType", "onResult"}, k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes15.dex */
        static final class a implements IOperateCallback {

            /* renamed from: a, reason: collision with root package name */
            public static final a f253268a = new a();

            a() {
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
            }
        }
    }
}
