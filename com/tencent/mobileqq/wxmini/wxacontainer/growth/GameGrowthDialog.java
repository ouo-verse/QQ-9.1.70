package com.tencent.mobileqq.wxmini.wxacontainer.growth;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.wxmini.impl.launcher.WxaInfo;
import com.tencent.mobileqq.wxmini.wxacontainer.growth.GameGrowthDialog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.tuxmeterqui.config.TuxUIConstants;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import lb3.GuardInstruction;
import lb3.g;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b9\u0010:J&\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u000e\u001a\u00020\fH\u0016J\u000e\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fJ\b\u0010\u0012\u001a\u00020\fH\u0016J\u0010\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u000e\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0016J\u000e\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0019R\"\u0010#\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010'\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010\u001e\u001a\u0004\b%\u0010 \"\u0004\b&\u0010\"R\"\u0010+\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010\u001e\u001a\u0004\b)\u0010 \"\u0004\b*\u0010\"R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00102\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/wxmini/wxacontainer/growth/GameGrowthDialog;", "Landroidx/fragment/app/DialogFragment;", "Landroid/content/DialogInterface;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "view", "", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/content/DialogInterface$OnClickListener;", "clickListener", "uh", "cancel", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "Lcom/tencent/mobileqq/wxmini/impl/launcher/WxaInfo;", "wxaInfo", "vh", "Llb3/h;", "instruction", "th", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "title", "D", "getContent", "sh", "content", "E", "getBtnText", "rh", TuxUIConstants.POP_BTN_TEXT, UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/wxmini/impl/launcher/WxaInfo;", "G", "Llb3/h;", "H", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "I", "Z", MiniChatConstants.MINI_APP_LANDSCAPE, "J", "Landroid/content/DialogInterface$OnClickListener;", "<init>", "()V", "wxmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class GameGrowthDialog extends DialogFragment implements DialogInterface {

    /* renamed from: C, reason: from kotlin metadata */
    private String title = "";

    /* renamed from: D, reason: from kotlin metadata */
    private String content = "";

    /* renamed from: E, reason: from kotlin metadata */
    private String btnText = "";

    /* renamed from: F, reason: from kotlin metadata */
    private WxaInfo wxaInfo;

    /* renamed from: G, reason: from kotlin metadata */
    private GuardInstruction instruction;

    /* renamed from: H, reason: from kotlin metadata */
    private View rootView;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean isLandscape;

    /* renamed from: J, reason: from kotlin metadata */
    private DialogInterface.OnClickListener clickListener;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void qh(GameGrowthDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogInterface.OnClickListener onClickListener = this$0.clickListener;
        if (onClickListener != null) {
            onClickListener.onClick(this$0, 0);
        }
        VideoReport.setElementId(view, "em_applet_confirm_button");
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0AND06A49O0PML4Z");
        VideoReport.reportEvent("dt_clck", view, hashMap);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        if (this.isLandscape != (newConfig.orientation == 2)) {
            dismissAllowingStateLoss();
            show(getParentFragmentManager(), "GameGrowthDialog");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        boolean z16 = getResources().getConfiguration().orientation == 2;
        this.isLandscape = z16;
        return inflater.inflate(z16 ? R.layout.czp : R.layout.czo, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        VideoReport.reportPgOut(this.rootView);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Window window;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        ((Button) view.findViewById(R.id.oy8)).setOnClickListener(new View.OnClickListener() { // from class: lb3.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                GameGrowthDialog.qh(GameGrowthDialog.this, view2);
            }
        });
        ((TextView) view.findViewById(R.id.oy_)).setText(this.title);
        ((TextView) view.findViewById(R.id.oy9)).setText(this.content);
        ((Button) view.findViewById(R.id.oy8)).setText(this.btnText);
        setCancelable(false);
        GuardInstruction guardInstruction = this.instruction;
        if (guardInstruction != null && this.wxaInfo != null) {
            Intrinsics.checkNotNull(guardInstruction);
            if (guardInstruction.getReportScene() == 3) {
                g gVar = g.f414306a;
                WxaInfo wxaInfo = this.wxaInfo;
                Intrinsics.checkNotNull(wxaInfo);
                gVar.k(view, "pg_applet_underage_tips_proper_game", wxaInfo);
            } else {
                g gVar2 = g.f414306a;
                WxaInfo wxaInfo2 = this.wxaInfo;
                Intrinsics.checkNotNull(wxaInfo2);
                gVar2.k(view, "pg_applet_underage_tips", wxaInfo2);
            }
        }
        this.rootView = view;
        VideoReport.reportPgIn(view);
    }

    public final void rh(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.btnText = str;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public final void sh(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.content = str;
    }

    public final void th(GuardInstruction instruction) {
        Intrinsics.checkNotNullParameter(instruction, "instruction");
        this.instruction = instruction;
    }

    public final void uh(DialogInterface.OnClickListener clickListener) {
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        this.clickListener = clickListener;
    }

    public final void vh(WxaInfo wxaInfo) {
        Intrinsics.checkNotNullParameter(wxaInfo, "wxaInfo");
        this.wxaInfo = wxaInfo;
    }

    @Override // android.content.DialogInterface
    public void cancel() {
    }
}
