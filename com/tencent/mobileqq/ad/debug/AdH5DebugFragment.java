package com.tencent.mobileqq.ad.debug;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0014J\u001a\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016R\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/ad/debug/AdH5DebugFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "initViews", "rh", "qh", "", "getContentLayoutId", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Landroid/widget/TextView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/TextView;", "mAdLoadingText", "<init>", "()V", "D", "a", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class AdH5DebugFragment extends QIphoneTitleBarFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private TextView mAdLoadingText;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/ad/debug/AdH5DebugFragment$a;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "a", "", "TAG", "Ljava/lang/String;", "TITLE", "<init>", "()V", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.ad.debug.AdH5DebugFragment$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        public final void a(@Nullable Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity);
            } else if (activity == null) {
                QLog.e("AdH5DebugFragment", 1, "start error");
            } else {
                QPublicFragmentActivity.start(activity, AdH5DebugFragment.class);
            }
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27751);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AdH5DebugFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void initViews(View rootView) {
        View findViewById = rootView.findViewById(R.id.f58732qt);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.qq_ad_loading)");
        this.mAdLoadingText = (TextView) findViewById;
    }

    private final void rh() {
        w.f186844a.e();
        TextView textView = this.mAdLoadingText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdLoadingText");
            textView = null;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.ad.debug.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AdH5DebugFragment.sh(AdH5DebugFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sh(AdH5DebugFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent(this$0.getContext(), (Class<?>) QQBrowserActivity.class);
        intent.putExtra("fragmentStyle", 11);
        intent.putExtra("url", "https://xj.gdt.qq.com/xjviewer/nemo/13875630/2000012941/60005012352827?qz_gdt=el5n4zidaaaa7ezdblsq&click_ext=eyJhdWlkIjoiMzExNDExNjEiLCJsb25nX3Bvc19pZCI6IjYwMTExOTUwMTU5OTgyMTgiLCJtZWRpdW1faWQiOiI2MDAwNTAxMjM1MjgyNyIsIm9zX3R5cGUiOjIsInNob3J0X3Bvc19pZCI6MTkyNDM3MCwid2l0aG91dEluc3RhbGxTdWNjZXNzIjoxfQ%3D%3D&clklpp=%7B%22click_time%22%3A1709111844622%2C%22toolsalive%22%3A0%2C%22preload%22%3A2%2C%22withOuterVideo%22%3A1%7D&autodownload=0&gdt_ad_id=13706797788&aidx=2131661058&gdt_product_id=2000012941&gdt_media_id=60005012352827&packageName=com.miHoYo.hkrpg&net_log_id=nzoguviagisai-1&xj_ui=1_0a1171dff9f16bf8_0a48&ad_id=13706798059");
        intent.putExtra("CONTENT_BACKGROUND_IMG", "https://business-1251316161.cos.ap-shanghai.myqcloud.com/web/landingpage3.jpg?q-sign-algorithm=sha1&q-ak=AKIDSqIo9joULg8lB_KsfXritzgZDpYzlbvKgf5qaO2mIFnIVtNIRH0Gf9euCIewgGrS&q-sign-time=1709175715;1709179315&q-key-time=1709175715;1709179315&q-header-list=host&q-url-param-list=ci-process&q-signature=e3ce15a01e6b047a1c905faefcd8f7a306c15984&x-cos-security-token=LM0apePRSr38oyhsnCd1oAIRMZABLR6ad975555a5ff09a431f6c72b59fe80fbafTBaUjxp-OooyxsoJOEil0lEoUp2jfnaTla7TjRhCLBDQeFAGfigfWoPmnLXCPi0WjEH5uTBTH5F7nBV2HrRcUsQnSS5QNM0umrTxmu00iUsq9fMFQkGj8XNHm4N-4dLisx7LExgRoTEz5gm0JpGDAL4U2lw8dFWRsvKxaWpJg3j5zV5a6FwtGwSjRz0NR5W&ci-process=originImage");
        this$0.startActivity(intent);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.layout.gvb;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setTitle("\u5e7f\u544aH5\u6d4b\u8bd5");
        initViews(view);
        rh();
        qh();
    }

    private final void qh() {
    }
}
