package com.tencent.mobileqq.guild.inbox.startpanel.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.inbox.startpanel.p;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.widget.listitem.QUIListItemStyle;
import com.tencent.mobileqq.widget.listitem.QUISingleLineListItem;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment;
import com.tencent.widget.Switch;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010&\u001a\u0004\u0018\u00010#\u00a2\u0006\u0004\bg\u0010hJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\u0012\u0010\r\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J$\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u0018\u001a\u00020\u0016H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\u0018\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0016H\u0016J\u000e\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0016J\b\u0010\u001f\u001a\u00020\u0002H\u0016J\u0010\u0010 \u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0016H\u0016J\u0006\u0010!\u001a\u00020\u0004J\u0006\u0010\"\u001a\u00020\u0004R\u0016\u0010&\u001a\u0004\u0018\u00010#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00103\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u0010(R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\"\u0010?\u001a\u0002088\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\"\u0010E\u001a\u00020\u00048\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b@\u0010(\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u0016\u0010G\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bF\u0010(R\u0016\u0010I\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bH\u00100R \u0010O\u001a\u000e\u0012\u0004\u0012\u00020K\u0012\u0004\u0012\u00020L0J8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bM\u0010NR \u0010Q\u001a\u000e\u0012\u0004\u0012\u00020K\u0012\u0004\u0012\u00020L0J8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bP\u0010NR\u0014\u0010T\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0014\u0010W\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bU\u0010VR\"\u0010^\u001a\u00020\u00168\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\"\u0010f\u001a\u00020_8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b`\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010e\u00a8\u0006i"}, d2 = {"Lcom/tencent/mobileqq/guild/inbox/startpanel/dialog/InboxNodeSettingBaseDialog;", "Landroidx/fragment/app/DialogFragment;", "", "Fh", "Landroid/view/View;", "contentRoot", "Eh", "Landroid/view/View$OnClickListener;", "th", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "vh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "onCreateView", "onResume", "onStart", "Qh", "", "Ih", "Hh", "", "xh", "view", "isChecked", "Dh", "Kh", "Lh", "Jh", "getRootView", "Bh", "Lcom/tencent/mobileqq/guild/inbox/startpanel/dialog/d;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/inbox/startpanel/dialog/d;", "callback", "D", "Landroid/view/View;", "mRootView", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "E", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "mFloatingView", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "mNameView", "G", "mMsgNotifyLayout", "Lcom/tencent/mobileqq/widget/listitem/QUISingleLineListItem;", "H", "Lcom/tencent/mobileqq/widget/listitem/QUISingleLineListItem;", "mMsgNotifyLayout2", "Lcom/tencent/widget/Switch;", "I", "Lcom/tencent/widget/Switch;", "Ah", "()Lcom/tencent/widget/Switch;", "Oh", "(Lcom/tencent/widget/Switch;)V", "mMsgNotifySwitch", "J", "yh", "()Landroid/view/View;", "Mh", "(Landroid/view/View;)V", "mDeleteButton", "K", "mDivider", "L", "mDeleteTextView", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b;", "Lcom/tencent/mobileqq/widget/listitem/x$c;", "M", "Lcom/tencent/mobileqq/widget/listitem/x;", "mNotifyConfig", "N", "mDeleteButtonConfig", "P", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "mOnCheckedChangeListener", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/view/View$OnClickListener;", "mDeleteClickListener", BdhLogUtil.LogTag.Tag_Req, "Z", OcrConfig.CHINESE, "()Z", "Nh", "(Z)V", "mIsCheck", "Lcom/tencent/mobileqq/guild/inbox/startpanel/p;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/guild/inbox/startpanel/p;", "Ch", "()Lcom/tencent/mobileqq/guild/inbox/startpanel/p;", "Ph", "(Lcom/tencent/mobileqq/guild/inbox/startpanel/p;)V", "nodeUIData", "<init>", "(Lcom/tencent/mobileqq/guild/inbox/startpanel/dialog/d;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public class InboxNodeSettingBaseDialog extends ReportAndroidXDialogFragment {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private final d callback;

    /* renamed from: D, reason: from kotlin metadata */
    private View mRootView;

    /* renamed from: E, reason: from kotlin metadata */
    private QUSHalfScreenFloatingView mFloatingView;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView mNameView;

    /* renamed from: G, reason: from kotlin metadata */
    private View mMsgNotifyLayout;

    /* renamed from: H, reason: from kotlin metadata */
    private QUISingleLineListItem mMsgNotifyLayout2;

    /* renamed from: I, reason: from kotlin metadata */
    protected Switch mMsgNotifySwitch;

    /* renamed from: J, reason: from kotlin metadata */
    protected View mDeleteButton;

    /* renamed from: K, reason: from kotlin metadata */
    private View mDivider;

    /* renamed from: L, reason: from kotlin metadata */
    private TextView mDeleteTextView;

    /* renamed from: R, reason: from kotlin metadata */
    private boolean mIsCheck;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final x<x.b, x.c> mNotifyConfig = new x<>(new x.b.d("\u6d88\u606f\u514d\u6253\u6270"), new x.c.f(false, null));

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final x<x.b, x.c> mDeleteButtonConfig = new x<>(new x.b.d("\u6d88\u606f\u514d\u6253\u6270"), new x.c.f(false, null));

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final CompoundButton.OnCheckedChangeListener mOnCheckedChangeListener = vh();

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final View.OnClickListener mDeleteClickListener = th();

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private p nodeUIData = new p();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/inbox/startpanel/dialog/InboxNodeSettingBaseDialog$a", "Lcom/tencent/mobileqq/widget/qus/e;", "Landroid/view/View;", "createContentView", "", "showMode", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a extends com.tencent.mobileqq.widget.qus.e {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QUSHalfScreenFloatingView f226254d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ InboxNodeSettingBaseDialog f226255e;

        a(QUSHalfScreenFloatingView qUSHalfScreenFloatingView, InboxNodeSettingBaseDialog inboxNodeSettingBaseDialog) {
            this.f226254d = qUSHalfScreenFloatingView;
            this.f226255e = inboxNodeSettingBaseDialog;
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        @Nullable
        /* renamed from: createContentView */
        public View getF57179d() {
            View view = LayoutInflater.from(this.f226254d.getContext()).inflate(R.layout.eur, (ViewGroup) null);
            InboxNodeSettingBaseDialog inboxNodeSettingBaseDialog = this.f226255e;
            Intrinsics.checkNotNullExpressionValue(view, "view");
            inboxNodeSettingBaseDialog.Eh(view);
            return view;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            return 1;
        }
    }

    public InboxNodeSettingBaseDialog(@Nullable d dVar) {
        this.callback = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Eh(View contentRoot) {
        int i3;
        int i16;
        View findViewById = contentRoot.findViewById(R.id.xlu);
        Intrinsics.checkNotNullExpressionValue(findViewById, "contentRoot.findViewById(R.id.inbox_name)");
        this.mNameView = (TextView) findViewById;
        View findViewById2 = contentRoot.findViewById(R.id.zg9);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "contentRoot.findViewById(R.id.msg_notify_layout)");
        this.mMsgNotifyLayout = findViewById2;
        View findViewById3 = contentRoot.findViewById(R.id.zg_);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "contentRoot.findViewById\u2026.id.msg_notify_layout_v2)");
        this.mMsgNotifyLayout2 = (QUISingleLineListItem) findViewById3;
        View findViewById4 = contentRoot.findViewById(R.id.zgc);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "contentRoot.findViewById(R.id.msg_notify_switch)");
        Oh((Switch) findViewById4);
        View findViewById5 = contentRoot.findViewById(R.id.f164965ug3);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "contentRoot.findViewById(R.id.delete_inbox_node)");
        Mh(findViewById5);
        View findViewById6 = contentRoot.findViewById(R.id.bmt);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "contentRoot.findViewById(R.id.divider)");
        this.mDivider = findViewById6;
        View findViewById7 = contentRoot.findViewById(R.id.ufz);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "contentRoot.findViewById(R.id.delete_btn_tv)");
        TextView textView = (TextView) findViewById7;
        this.mDeleteTextView = textView;
        QUISingleLineListItem qUISingleLineListItem = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDeleteTextView");
            textView = null;
        }
        textView.setText(xh());
        TextView textView2 = this.mNameView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNameView");
            textView2 = null;
        }
        textView2.setText(this.nodeUIData.f226299i);
        View view = this.mMsgNotifyLayout;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMsgNotifyLayout");
            view = null;
        }
        int i17 = 0;
        if (Ih()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
        View yh5 = yh();
        if (getIsShowDeleteButton()) {
            i16 = 0;
        } else {
            i16 = 8;
        }
        yh5.setVisibility(i16);
        View view2 = this.mDivider;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDivider");
            view2 = null;
        }
        if (!getIsShowDeleteButton()) {
            i17 = 8;
        }
        view2.setVisibility(i17);
        Ah().setOnCheckedChangeListener(this.mOnCheckedChangeListener);
        yh().setOnClickListener(this.mDeleteClickListener);
        QUISingleLineListItem qUISingleLineListItem2 = this.mMsgNotifyLayout2;
        if (qUISingleLineListItem2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMsgNotifyLayout2");
            qUISingleLineListItem2 = null;
        }
        qUISingleLineListItem2.setConfig(this.mNotifyConfig);
        QUISingleLineListItem qUISingleLineListItem3 = this.mMsgNotifyLayout2;
        if (qUISingleLineListItem3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMsgNotifyLayout2");
        } else {
            qUISingleLineListItem = qUISingleLineListItem3;
        }
        qUISingleLineListItem.setStyle(QUIListItemStyle.Card);
        Lh();
    }

    private final void Fh() {
        View view = this.mRootView;
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        View findViewById = view.findViewById(R.id.f66733bf);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R\u2026qus_floating_half_screen)");
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView2 = (QUSHalfScreenFloatingView) findViewById;
        this.mFloatingView = qUSHalfScreenFloatingView2;
        if (qUSHalfScreenFloatingView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFloatingView");
        } else {
            qUSHalfScreenFloatingView = qUSHalfScreenFloatingView2;
        }
        qUSHalfScreenFloatingView.setIsHeightWrapContent(true);
        qUSHalfScreenFloatingView.setQUSDragFloatController(new a(qUSHalfScreenFloatingView, this));
        qUSHalfScreenFloatingView.J();
        qUSHalfScreenFloatingView.setOnDismissListener(new QUSBaseHalfScreenFloatingView.l() { // from class: com.tencent.mobileqq.guild.inbox.startpanel.dialog.h
            @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
            public final void onDismiss() {
                InboxNodeSettingBaseDialog.Gh(InboxNodeSettingBaseDialog.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gh(InboxNodeSettingBaseDialog this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    private final View.OnClickListener th() {
        return new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.inbox.startpanel.dialog.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InboxNodeSettingBaseDialog.uh(InboxNodeSettingBaseDialog.this, view);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void uh(InboxNodeSettingBaseDialog this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        d dVar = this$0.callback;
        if (dVar != null) {
            dVar.a(this$0.nodeUIData);
        }
        this$0.dismiss();
        VideoReport.reportEvent("clck", this$0.yh(), null);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final CompoundButton.OnCheckedChangeListener vh() {
        return new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.guild.inbox.startpanel.dialog.i
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                InboxNodeSettingBaseDialog.wh(InboxNodeSettingBaseDialog.this, compoundButton, z16);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wh(InboxNodeSettingBaseDialog this$0, CompoundButton view, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(view, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(view, "view");
        this$0.Dh(view, z16);
        this$0.Jh(z16);
        EventCollector.getInstance().onCompoundButtonChecked(view, z16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final Switch Ah() {
        Switch r06 = this.mMsgNotifySwitch;
        if (r06 != null) {
            return r06;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mMsgNotifySwitch");
        return null;
    }

    @NotNull
    public final View Bh() {
        View view = this.mMsgNotifyLayout;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMsgNotifyLayout");
            return null;
        }
        return view;
    }

    @NotNull
    /* renamed from: Ch, reason: from getter */
    public final p getNodeUIData() {
        return this.nodeUIData;
    }

    public void Dh(@NotNull View view, boolean isChecked) {
        throw null;
    }

    /* renamed from: Hh */
    public boolean getIsShowDeleteButton() {
        throw null;
    }

    public boolean Ih() {
        throw null;
    }

    public void Jh(boolean isChecked) {
        String str;
        HashMap hashMap = new HashMap(1);
        if (isChecked) {
            str = "1";
        } else {
            str = "2";
        }
        hashMap.put("sgrp_private_push_switch", str);
        VideoReport.reportEvent("clck", Ah(), hashMap);
    }

    public final void Kh(boolean isChecked) {
        QUISingleLineListItem qUISingleLineListItem = null;
        Ah().setOnCheckedChangeListener(null);
        Ah().setChecked(isChecked);
        Ah().setOnCheckedChangeListener(this.mOnCheckedChangeListener);
        this.mNotifyConfig.U(new x.c.f(isChecked, this.mOnCheckedChangeListener));
        QUISingleLineListItem qUISingleLineListItem2 = this.mMsgNotifyLayout2;
        if (qUISingleLineListItem2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMsgNotifyLayout2");
        } else {
            qUISingleLineListItem = qUISingleLineListItem2;
        }
        qUISingleLineListItem.setConfig(this.mNotifyConfig);
    }

    public void Lh() {
        View view = this.mRootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        VideoReport.setPageId(view, "pg_sgrp_mine");
        View yh5 = yh();
        ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_NONE;
        ch.Y0(yh5, "em_sgrp_private_delete", clickPolicy, exposurePolicy);
        ch.Y0(Ah(), "em_sgrp_private_push_switch", clickPolicy, exposurePolicy);
    }

    protected final void Mh(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.mDeleteButton = view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Nh(boolean z16) {
        this.mIsCheck = z16;
    }

    protected final void Oh(@NotNull Switch r26) {
        Intrinsics.checkNotNullParameter(r26, "<set-?>");
        this.mMsgNotifySwitch = r26;
    }

    public final void Ph(@NotNull p pVar) {
        Intrinsics.checkNotNullParameter(pVar, "<set-?>");
        this.nodeUIData = pVar;
    }

    public void Qh() {
        throw null;
    }

    @NotNull
    public final View getRootView() {
        View view = this.mRootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            return null;
        }
        return view;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(0, R.style.f173448dl);
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.e3i, container);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(com.ten\u2026g_half_screen, container)");
        this.mRootView = inflate;
        Fh();
        Qh();
        View view = this.mRootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        View view = this.mRootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        ViewParent parent = view.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) parent).setBackgroundColor(0);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (getDialog() != null) {
            Dialog dialog = getDialog();
            Intrinsics.checkNotNull(dialog);
            if (dialog.getWindow() != null) {
                Dialog dialog2 = getDialog();
                Intrinsics.checkNotNull(dialog2);
                Window window = dialog2.getWindow();
                Intrinsics.checkNotNull(window);
                GuildUIUtils.H(window);
            }
        }
    }

    public int xh() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final View yh() {
        View view = this.mDeleteButton;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mDeleteButton");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: zh, reason: from getter */
    public final boolean getMIsCheck() {
        return this.mIsCheck;
    }
}
