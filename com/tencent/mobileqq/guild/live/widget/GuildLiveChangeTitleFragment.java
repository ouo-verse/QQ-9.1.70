package com.tencent.mobileqq.guild.live.widget;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.impl.GuildDTReportApiImpl;
import com.tencent.mobileqq.guild.data.w;
import com.tencent.mobileqq.guild.live.livemanager.GLiveChannelCore;
import com.tencent.mobileqq.guild.live.livemanager.anchor.GLiveRoomInfo;
import com.tencent.mobileqq.guild.util.bv;
import com.tencent.mobileqq.guild.util.cb;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.z;
import com.tencent.mobileqq.guild.widget.CharacterCountEditText;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.util.InputMethodUtil;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 A2\u00020\u00012\u00020\u0002:\u0001BB\u0017\u0012\u0006\u0010%\u001a\u00020\u001e\u0012\u0006\u0010+\u001a\u00020&\u00a2\u0006\u0004\b?\u0010@J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0003H\u0002J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u0003H\u0002J&\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0012\u0010\u001a\u001a\u00020\u00192\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u001b\u001a\u00020\u0003H\u0016J\b\u0010\u001c\u001a\u00020\u0003H\u0016J\b\u0010\u001d\u001a\u00020\u0003H\u0016R\"\u0010%\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0017\u0010+\u001a\u00020&8\u0006\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00100\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u0010-R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0014\u0010<\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010>\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010:\u00a8\u0006C"}, d2 = {"Lcom/tencent/mobileqq/guild/live/widget/GuildLiveChangeTitleFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "initView", "xh", OcrConfig.CHINESE, "", "bottomPadding", "Eh", "Dh", "Landroid/view/View;", "view", "Hh", "Gh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreateView", "Landroid/content/DialogInterface;", "dialog", "onCancel", "Landroid/app/Dialog;", "onCreateDialog", "dismissAllowingStateLoss", "onStart", "onGlobalLayout", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "getMTitle", "()Ljava/lang/String;", "setMTitle", "(Ljava/lang/String;)V", "mTitle", "Lcom/tencent/mobileqq/guild/live/widget/GuildLiveTopMoreDialogFragment;", "D", "Lcom/tencent/mobileqq/guild/live/widget/GuildLiveTopMoreDialogFragment;", "getMLastFragment", "()Lcom/tencent/mobileqq/guild/live/widget/GuildLiveTopMoreDialogFragment;", "mLastFragment", "E", "Landroid/view/View;", "mSaveBtn", UserInfo.SEX_FEMALE, "mRootView", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "mCountView", "Lcom/tencent/mobileqq/guild/widget/CharacterCountEditText;", "H", "Lcom/tencent/mobileqq/guild/widget/CharacterCountEditText;", "mEditTv", "Landroid/graphics/Rect;", "I", "Landroid/graphics/Rect;", "mRect", "J", "mUsableHeightPrevious", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/guild/live/widget/GuildLiveTopMoreDialogFragment;)V", "K", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildLiveChangeTitleFragment extends BottomSheetDialogFragment implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private String mTitle;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final GuildLiveTopMoreDialogFragment mLastFragment;

    /* renamed from: E, reason: from kotlin metadata */
    private View mSaveBtn;

    /* renamed from: F, reason: from kotlin metadata */
    private View mRootView;

    /* renamed from: G, reason: from kotlin metadata */
    private TextView mCountView;

    /* renamed from: H, reason: from kotlin metadata */
    private CharacterCountEditText mEditTv;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Rect mRect;

    /* renamed from: J, reason: from kotlin metadata */
    private int mUsableHeightPrevious;

    public GuildLiveChangeTitleFragment(@NotNull String mTitle, @NotNull GuildLiveTopMoreDialogFragment mLastFragment) {
        Intrinsics.checkNotNullParameter(mTitle, "mTitle");
        Intrinsics.checkNotNullParameter(mLastFragment, "mLastFragment");
        this.mTitle = mTitle;
        this.mLastFragment = mLastFragment;
        this.mRect = new Rect();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ah(GuildLiveChangeTitleFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        CharacterCountEditText characterCountEditText = this$0.mEditTv;
        CharacterCountEditText characterCountEditText2 = null;
        if (characterCountEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditTv");
            characterCountEditText = null;
        }
        characterCountEditText.clearFocus();
        CharacterCountEditText characterCountEditText3 = this$0.mEditTv;
        if (characterCountEditText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditTv");
        } else {
            characterCountEditText2 = characterCountEditText3;
        }
        InputMethodUtil.hide(characterCountEditText2);
        this$0.dismissAllowingStateLoss();
        this$0.mLastFragment.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Bh(GuildLiveChangeTitleFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
        com.tencent.mobileqq.guild.live.livemanager.anchor.e h16 = gLiveChannelCore.h();
        int liveType = gLiveChannelCore.s().getLiveType();
        CharacterCountEditText characterCountEditText = this$0.mEditTv;
        if (characterCountEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditTv");
            characterCountEditText = null;
        }
        h16.e(liveType, new GLiveRoomInfo(characterCountEditText.getText().toString(), ""), 1, null);
        this$0.zh();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ch(GuildLiveChangeTitleFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.xh();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Dh() {
        Window window;
        View decorView;
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null && (decorView = window.getDecorView()) != null) {
            decorView.setPadding(0, 0, 0, 0);
        }
    }

    private final void Eh(int bottomPadding) {
        com.google.android.material.bottomsheet.a aVar;
        Window window;
        View decorView;
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null && (decorView = window.getDecorView()) != null) {
            decorView.setPadding(0, 0, 0, bottomPadding);
        }
        Dialog dialog2 = getDialog();
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = null;
        if (dialog2 instanceof com.google.android.material.bottomsheet.a) {
            aVar = (com.google.android.material.bottomsheet.a) dialog2;
        } else {
            aVar = null;
        }
        if (aVar != null) {
            bottomSheetBehavior = aVar.getBehavior();
        }
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.setState(3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fh(GuildLiveChangeTitleFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        CharacterCountEditText characterCountEditText = this$0.mEditTv;
        CharacterCountEditText characterCountEditText2 = null;
        if (characterCountEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditTv");
            characterCountEditText = null;
        }
        characterCountEditText.clearFocus();
        CharacterCountEditText characterCountEditText3 = this$0.mEditTv;
        if (characterCountEditText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditTv");
        } else {
            characterCountEditText2 = characterCountEditText3;
        }
        InputMethodUtil.hide(characterCountEditText2);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Gh() {
        GuildDTReportApiImpl guildDTReportApiImpl = ch.f235509b;
        View view = this.mSaveBtn;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSaveBtn");
            view = null;
        }
        guildDTReportApiImpl.setElementExposureAndClickParams(view, "em_sgrp_stream_thdone", null);
    }

    private final void Hh(View view) {
        GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
        IGProChannelInfo channelInfo = gLiveChannelCore.s().getChannelInfo();
        IGProGuildInfo guildInfo = gLiveChannelCore.s().getGuildInfo();
        if (channelInfo != null && guildInfo != null) {
            z zVar = new z(channelInfo, guildInfo);
            String anchorTinyId = gLiveChannelCore.s().getAnchorTinyId();
            HashMap<String, Object> pageParams = zVar.b();
            Intrinsics.checkNotNullExpressionValue(pageParams, "pageParams");
            pageParams.put("sgrp_access_id", anchorTinyId);
            w.a(pageParams);
            VideoReport.addToDetectionWhitelist(getActivity());
            VideoReport.setPageId(view, "pg_sgrp_stream_aio");
            ch.f235509b.setChannelPageParams(view, channelInfo, pageParams);
        }
    }

    private final void initView() {
        View view = this.mRootView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        View findViewById = view.findViewById(R.id.ifr);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById<View>(R.id.save)");
        this.mSaveBtn = findViewById;
        if (findViewById == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSaveBtn");
            findViewById = null;
        }
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.live.widget.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                GuildLiveChangeTitleFragment.Bh(GuildLiveChangeTitleFragment.this, view3);
            }
        });
        View view3 = this.mRootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view3 = null;
        }
        view3.findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.live.widget.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                GuildLiveChangeTitleFragment.Ch(GuildLiveChangeTitleFragment.this, view4);
            }
        });
        View view4 = this.mRootView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view4 = null;
        }
        View findViewById2 = view4.findViewById(R.id.bap);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById(R.id.count_text)");
        this.mCountView = (TextView) findViewById2;
        View view5 = this.mRootView;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view5 = null;
        }
        View findViewById3 = view5.findViewById(R.id.btb);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mRootView.findViewById(R.id.edit_text)");
        this.mEditTv = (CharacterCountEditText) findViewById3;
        TextView textView = this.mCountView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCountView");
            textView = null;
        }
        textView.setText(this.mTitle.length() + "/20");
        CharacterCountEditText characterCountEditText = this.mEditTv;
        if (characterCountEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditTv");
            characterCountEditText = null;
        }
        characterCountEditText.setLimitCount(20);
        characterCountEditText.setCountChangeListener(new b());
        characterCountEditText.setText(this.mTitle);
        characterCountEditText.setSelection(this.mTitle.length());
        View view6 = this.mRootView;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        } else {
            view2 = view6;
        }
        view2.getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    private final void xh() {
        Dialog dialog = getDialog();
        Intrinsics.checkNotNull(dialog, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        ((com.google.android.material.bottomsheet.a) dialog).getBehavior().setState(4);
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.live.widget.b
            @Override // java.lang.Runnable
            public final void run() {
                GuildLiveChangeTitleFragment.yh(GuildLiveChangeTitleFragment.this);
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void yh(GuildLiveChangeTitleFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
        this$0.mLastFragment.onBack();
    }

    private final void zh() {
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.live.widget.e
            @Override // java.lang.Runnable
            public final void run() {
                GuildLiveChangeTitleFragment.Ah(GuildLiveChangeTitleFragment.this);
            }
        }, 100L);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.fragment.app.DialogFragment
    public void dismissAllowingStateLoss() {
        super.dismissAllowingStateLoss();
        View view = this.mRootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(@NotNull DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onCancel(dialog);
        QLog.i("GuildLiveChangeTitleFragment", 1, "[onCancel] ");
        xh();
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Dialog onCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNull(onCreateDialog, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) onCreateDialog;
        Window window = aVar.getWindow();
        Intrinsics.checkNotNull(window);
        window.getAttributes().windowAnimations = R.style.f174032aw0;
        return aVar;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.ews, container, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou\u2026dialog, container, false)");
        this.mRootView = inflate;
        initView();
        Dialog dialog = getDialog();
        Intrinsics.checkNotNull(dialog);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setSoftInputMode(32);
        }
        View view = this.mRootView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        Hh(view);
        Gh();
        View view3 = this.mRootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        } else {
            view2 = view3;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view2);
        return view2;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        View view = this.mRootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        view.getWindowVisibleDisplayFrame(this.mRect);
        Rect rect = this.mRect;
        int i3 = rect.bottom - rect.top;
        if (i3 != this.mUsableHeightPrevious) {
            int a16 = bv.a(getActivity());
            int i16 = a16 - i3;
            if (i16 > a16 / 4) {
                Eh(i16 - bv.c(getActivity()));
            } else {
                Dh();
            }
            this.mUsableHeightPrevious = i3;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        View view = this.mRootView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        ((ViewGroup) view.getRootView().findViewById(tp1.a.b())).setBackgroundResource(17170445);
        View view3 = this.mRootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        } else {
            view2 = view3;
        }
        view2.getRootView().findViewById(tp1.a.c()).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.live.widget.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                GuildLiveChangeTitleFragment.Fh(GuildLiveChangeTitleFragment.this, view4);
            }
        });
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/live/widget/GuildLiveChangeTitleFragment$b", "Lcom/tencent/mobileqq/guild/widget/CharacterCountEditText$c;", "Lcom/tencent/mobileqq/guild/util/cb$b;", "countInfo", "", ICustomDataEditor.STRING_PARAM_7, "Bf", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements CharacterCountEditText.c {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.widget.CharacterCountEditText.c
        public void s7(@Nullable cb.b countInfo) {
            CharSequence trim;
            boolean z16;
            if (countInfo != null) {
                GuildLiveChangeTitleFragment guildLiveChangeTitleFragment = GuildLiveChangeTitleFragment.this;
                TextView textView = guildLiveChangeTitleFragment.mCountView;
                CharacterCountEditText characterCountEditText = null;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCountView");
                    textView = null;
                }
                textView.setText(countInfo.c() + "/20");
                View view = guildLiveChangeTitleFragment.mSaveBtn;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSaveBtn");
                    view = null;
                }
                boolean z17 = false;
                if (countInfo.c() > 0) {
                    CharacterCountEditText characterCountEditText2 = guildLiveChangeTitleFragment.mEditTv;
                    if (characterCountEditText2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mEditTv");
                    } else {
                        characterCountEditText = characterCountEditText2;
                    }
                    Editable text = characterCountEditText.getText();
                    Intrinsics.checkNotNullExpressionValue(text, "mEditTv.text");
                    trim = StringsKt__StringsKt.trim(text);
                    if (trim.length() > 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        z17 = true;
                    }
                }
                view.setEnabled(z17);
            }
        }

        @Override // com.tencent.mobileqq.guild.widget.CharacterCountEditText.c
        public void Bf(@Nullable cb.b countInfo) {
        }
    }
}
