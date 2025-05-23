package com.tencent.mobileqq.guild.profile.me.edit;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.mobileqq.guild.util.cb;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.widget.CharacterCountEditText;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProPersonalSignatureTemplate;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.util.InputMethodUtil;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0011\u0018\u0000 I2\u00020\u0001:\u0002JKB\u0007\u00a2\u0006\u0004\bG\u0010HJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J$\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0018\u001a\u00020\u0002H\u0016J0\u0010 \u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00192\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00020\u001eR\u0016\u0010#\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010&R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00103\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u0010&R\u0016\u00105\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00100R\u0016\u00107\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u0010&R\u001e\u0010:\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010=\u001a\u00020;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u00104R\u0014\u0010@\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010C\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR$\u0010F\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010E\u00a8\u0006L"}, d2 = {"Lcom/tencent/mobileqq/guild/profile/me/edit/GuildPersonalSignatureEditDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "", "initView", "vh", "Gh", "Fh", "Ih", "Lcom/tencent/mobileqq/guild/widget/CharacterCountEditText$c;", OcrConfig.CHINESE, "", NodeProps.ENABLED, "Eh", "Dh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", "", "signatureContent", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProPersonalSignatureTemplate;", "signatureTemplates", "Lkotlin/Function1;", "finishCallback", "Bh", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "mRootView", "Landroid/widget/TextView;", "D", "Landroid/widget/TextView;", "mCancelBtn", "E", "mFinishBtn", "Lcom/tencent/mobileqq/guild/widget/CharacterCountEditText;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/widget/CharacterCountEditText;", "mEditText", "Landroid/widget/ImageView;", "G", "Landroid/widget/ImageView;", "mTemplateAvatar", "H", "mTemplateText", "I", "mTemplateRefresh", "J", "mInputCount", "K", "Ljava/util/List;", "mSignatureTemplates", "", "L", "mSignatureTemplateIndex", "M", "Lcom/tencent/mobileqq/guild/widget/CharacterCountEditText$c;", "mTextChangeListener", "N", "Ljava/lang/String;", "mSignatureContent", "P", "Lkotlin/jvm/functions/Function1;", "mFinishCallback", "<init>", "()V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildPersonalSignatureEditDialog extends BottomSheetDialogFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private View mRootView;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView mCancelBtn;

    /* renamed from: E, reason: from kotlin metadata */
    private TextView mFinishBtn;

    /* renamed from: F, reason: from kotlin metadata */
    private CharacterCountEditText mEditText;

    /* renamed from: G, reason: from kotlin metadata */
    private ImageView mTemplateAvatar;

    /* renamed from: H, reason: from kotlin metadata */
    private TextView mTemplateText;

    /* renamed from: I, reason: from kotlin metadata */
    private ImageView mTemplateRefresh;

    /* renamed from: J, reason: from kotlin metadata */
    private TextView mInputCount;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private List<? extends IGProPersonalSignatureTemplate> mSignatureTemplates;

    /* renamed from: L, reason: from kotlin metadata */
    private int mSignatureTemplateIndex = -1;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final CharacterCountEditText.c mTextChangeListener = zh();

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private String mSignatureContent = "";

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private Function1<? super String, Unit> mFinishCallback;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\u0011\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0018\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001d\u0010\u001eJ*\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J*\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\fH\u0016R\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0018\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0015R\u0016\u0010\u001c\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0015\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/guild/profile/me/edit/GuildPersonalSignatureEditDialog$a;", "Landroid/text/TextWatcher;", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "", "d", BdhLogUtil.LogTag.Tag_Conn, "getLimitCharacter", "()C", "limitCharacter", "e", "I", "getLimitNum", "()I", "limitNum", "f", "mRemoveStart", tl.h.F, "mRemoveEnd", "<init>", "(CI)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a implements TextWatcher {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final char limitCharacter;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int limitNum;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private int mRemoveStart;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private int mRemoveEnd;

        public a(char c16, int i3) {
            this.limitCharacter = c16;
            this.limitNum = i3;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable s16) {
            int i3 = this.mRemoveStart;
            int i16 = this.mRemoveEnd;
            if (i3 != i16 && s16 != null) {
                s16.replace(i3, i16, "");
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence s16, int start, int count, int after) {
            this.mRemoveStart = 0;
            this.mRemoveEnd = 0;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence s16, int start, int before, int count) {
            boolean contains$default;
            boolean z16;
            if (s16 == null) {
                return;
            }
            int i3 = count + start;
            contains$default = StringsKt__StringsKt.contains$default(s16.subSequence(start, i3), this.limitCharacter, false, 2, (Object) null);
            if (!contains$default) {
                return;
            }
            int i16 = 0;
            for (int i17 = 0; i17 < s16.length(); i17++) {
                if (s16.charAt(i17) == this.limitCharacter) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    i16++;
                }
            }
            if (i16 < this.limitNum) {
                return;
            }
            this.mRemoveStart = start;
            this.mRemoveEnd = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ah(GuildPersonalSignatureEditDialog this$0, cb.b bVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView textView = this$0.mInputCount;
        CharacterCountEditText characterCountEditText = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInputCount");
            textView = null;
        }
        textView.setText(bVar.a() + "/120");
        String str = this$0.mSignatureContent;
        CharacterCountEditText characterCountEditText2 = this$0.mEditText;
        if (characterCountEditText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        } else {
            characterCountEditText = characterCountEditText2;
        }
        if (!TextUtils.equals(str, characterCountEditText.getText().toString())) {
            this$0.Eh(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Ch(View view, MotionEvent motionEvent) {
        ViewParent parent;
        if (view != null && (parent = view.getParent()) != null) {
            parent.requestDisallowInterceptTouchEvent(true);
            return false;
        }
        return false;
    }

    private final void Dh() {
        View view = this.mRootView;
        TextView textView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        VideoReport.setPageId(view, "pg_sgrp_mine_edit");
        TextView textView2 = this.mCancelBtn;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCancelBtn");
            textView2 = null;
        }
        ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_NONE;
        ch.Y0(textView2, "em_sgrp_mine_selfintro_cancel", clickPolicy, exposurePolicy);
        TextView textView3 = this.mFinishBtn;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFinishBtn");
        } else {
            textView = textView3;
        }
        ch.Y0(textView, "em_sgrp_mine_selfintro_finish", clickPolicy, exposurePolicy);
    }

    private final void Eh(boolean enabled) {
        float f16;
        TextView textView = this.mFinishBtn;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFinishBtn");
            textView = null;
        }
        textView.setEnabled(enabled);
        TextView textView3 = this.mFinishBtn;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFinishBtn");
        } else {
            textView2 = textView3;
        }
        if (enabled) {
            f16 = 1.0f;
        } else {
            f16 = 0.3f;
        }
        textView2.setAlpha(f16);
    }

    private final void Fh() {
        CharacterCountEditText characterCountEditText = this.mEditText;
        CharacterCountEditText characterCountEditText2 = null;
        if (characterCountEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            characterCountEditText = null;
        }
        characterCountEditText.setText(this.mSignatureContent);
        CharacterCountEditText characterCountEditText3 = this.mEditText;
        if (characterCountEditText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            characterCountEditText3 = null;
        }
        CharacterCountEditText characterCountEditText4 = this.mEditText;
        if (characterCountEditText4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        } else {
            characterCountEditText2 = characterCountEditText4;
        }
        characterCountEditText3.setSelection(characterCountEditText2.getText().length());
        Ih();
    }

    private final void Gh() {
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior;
        View view = this.mRootView;
        CharacterCountEditText characterCountEditText = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        ViewParent parent = view.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) parent).setBackgroundColor(0);
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) getDialog();
        int c16 = bi.c();
        if (aVar != null) {
            bottomSheetBehavior = aVar.getBehavior();
        } else {
            bottomSheetBehavior = null;
        }
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.setPeekHeight((int) (c16 * 0.85f));
        }
        CharacterCountEditText characterCountEditText2 = this.mEditText;
        if (characterCountEditText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        } else {
            characterCountEditText = characterCountEditText2;
        }
        characterCountEditText.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.profile.me.edit.ac
            @Override // java.lang.Runnable
            public final void run() {
                GuildPersonalSignatureEditDialog.Hh(GuildPersonalSignatureEditDialog.this);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Hh(GuildPersonalSignatureEditDialog this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        CharacterCountEditText characterCountEditText = this$0.mEditText;
        CharacterCountEditText characterCountEditText2 = null;
        if (characterCountEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            characterCountEditText = null;
        }
        characterCountEditText.requestFocus();
        CharacterCountEditText characterCountEditText3 = this$0.mEditText;
        if (characterCountEditText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        } else {
            characterCountEditText2 = characterCountEditText3;
        }
        InputMethodUtil.show(characterCountEditText2);
    }

    private final void Ih() {
        boolean z16;
        List<? extends IGProPersonalSignatureTemplate> list = this.mSignatureTemplates;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        int i3 = this.mSignatureTemplateIndex + 1;
        this.mSignatureTemplateIndex = i3;
        List<? extends IGProPersonalSignatureTemplate> list2 = this.mSignatureTemplates;
        Intrinsics.checkNotNull(list2);
        if (i3 >= list2.size()) {
            this.mSignatureTemplateIndex = 0;
        }
        List<? extends IGProPersonalSignatureTemplate> list3 = this.mSignatureTemplates;
        Intrinsics.checkNotNull(list3);
        IGProPersonalSignatureTemplate iGProPersonalSignatureTemplate = list3.get(this.mSignatureTemplateIndex);
        String avatarUrl = iGProPersonalSignatureTemplate.getAvatarUrl();
        Intrinsics.checkNotNullExpressionValue(avatarUrl, "signatureExample.avatarUrl");
        ImageView imageView = this.mTemplateAvatar;
        TextView textView = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTemplateAvatar");
            imageView = null;
        }
        com.tencent.mobileqq.guild.util.v.l(avatarUrl, imageView, null, 4, null);
        TextView textView2 = this.mTemplateText;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTemplateText");
        } else {
            textView = textView2;
        }
        textView.setText(iGProPersonalSignatureTemplate.getSampleText());
    }

    private final void initView() {
        View view = this.mRootView;
        CharacterCountEditText characterCountEditText = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        View findViewById = view.findViewById(R.id.upz);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R.id.edit_cancel)");
        this.mCancelBtn = (TextView) findViewById;
        View view2 = this.mRootView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view2 = null;
        }
        View findViewById2 = view2.findViewById(R.id.uq8);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById(R.id.edit_done)");
        this.mFinishBtn = (TextView) findViewById2;
        View view3 = this.mRootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view3 = null;
        }
        View findViewById3 = view3.findViewById(R.id.uqp);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mRootView.findViewById(R.id.edit_signature)");
        this.mEditText = (CharacterCountEditText) findViewById3;
        View view4 = this.mRootView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view4 = null;
        }
        View findViewById4 = view4.findViewById(R.id.uqq);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "mRootView.findViewById(R.id.edit_template_avatar)");
        this.mTemplateAvatar = (ImageView) findViewById4;
        View view5 = this.mRootView;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view5 = null;
        }
        View findViewById5 = view5.findViewById(R.id.uqr);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "mRootView.findViewById(R.id.edit_template_text)");
        this.mTemplateText = (TextView) findViewById5;
        View view6 = this.mRootView;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view6 = null;
        }
        View findViewById6 = view6.findViewById(R.id.uxx);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "mRootView.findViewById(R.id.exit_template_refresh)");
        this.mTemplateRefresh = (ImageView) findViewById6;
        View view7 = this.mRootView;
        if (view7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view7 = null;
        }
        View findViewById7 = view7.findViewById(R.id.uqf);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "mRootView.findViewById(R.id.edit_input_count)");
        this.mInputCount = (TextView) findViewById7;
        Eh(false);
        CharacterCountEditText characterCountEditText2 = this.mEditText;
        if (characterCountEditText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            characterCountEditText2 = null;
        }
        characterCountEditText2.setLimitCount(120);
        CharacterCountEditText characterCountEditText3 = this.mEditText;
        if (characterCountEditText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            characterCountEditText3 = null;
        }
        characterCountEditText3.setCountChangeListener(this.mTextChangeListener);
        CharacterCountEditText characterCountEditText4 = this.mEditText;
        if (characterCountEditText4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            characterCountEditText4 = null;
        }
        characterCountEditText4.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.guild.profile.me.edit.ae
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view8, MotionEvent motionEvent) {
                boolean Ch;
                Ch = GuildPersonalSignatureEditDialog.Ch(view8, motionEvent);
                return Ch;
            }
        });
        CharacterCountEditText characterCountEditText5 = this.mEditText;
        if (characterCountEditText5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        } else {
            characterCountEditText = characterCountEditText5;
        }
        characterCountEditText.addTextChangedListener(new a('\n', 5));
    }

    private final void vh() {
        ImageView imageView = this.mTemplateRefresh;
        TextView textView = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTemplateRefresh");
            imageView = null;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.profile.me.edit.af
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildPersonalSignatureEditDialog.wh(GuildPersonalSignatureEditDialog.this, view);
            }
        });
        TextView textView2 = this.mFinishBtn;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFinishBtn");
            textView2 = null;
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.profile.me.edit.ag
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildPersonalSignatureEditDialog.xh(GuildPersonalSignatureEditDialog.this, view);
            }
        });
        TextView textView3 = this.mCancelBtn;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCancelBtn");
        } else {
            textView = textView3;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.profile.me.edit.ah
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildPersonalSignatureEditDialog.yh(GuildPersonalSignatureEditDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wh(GuildPersonalSignatureEditDialog this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!com.tencent.mobileqq.guild.util.o.c("fastClickGuard")) {
            this$0.Ih();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xh(GuildPersonalSignatureEditDialog this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!com.tencent.mobileqq.guild.util.o.c("fastClickGuard")) {
            Function1<? super String, Unit> function1 = this$0.mFinishCallback;
            if (function1 == null) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                bVar.a().add("finish click error");
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("Guild.profile.GuildPersonalSignatureEditDialog", 1, (String) it.next(), null);
                }
            } else {
                Intrinsics.checkNotNull(function1);
                CharacterCountEditText characterCountEditText = this$0.mEditText;
                if (characterCountEditText == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mEditText");
                    characterCountEditText = null;
                }
                function1.invoke(characterCountEditText.getText().toString());
            }
            this$0.dismiss();
            VideoReport.reportEvent("clck", view, null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void yh(GuildPersonalSignatureEditDialog this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!com.tencent.mobileqq.guild.util.o.c("fastClickGuard")) {
            this$0.dismiss();
            VideoReport.reportEvent("clck", view, null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final CharacterCountEditText.c zh() {
        return new CharacterCountEditText.c() { // from class: com.tencent.mobileqq.guild.profile.me.edit.ad
            @Override // com.tencent.mobileqq.guild.widget.CharacterCountEditText.c
            public /* synthetic */ void Bf(cb.b bVar) {
                com.tencent.mobileqq.guild.widget.f.a(this, bVar);
            }

            @Override // com.tencent.mobileqq.guild.widget.CharacterCountEditText.c
            public final void s7(cb.b bVar) {
                GuildPersonalSignatureEditDialog.Ah(GuildPersonalSignatureEditDialog.this, bVar);
            }
        };
    }

    public final void Bh(@NotNull String signatureContent, @NotNull List<? extends IGProPersonalSignatureTemplate> signatureTemplates, @NotNull Function1<? super String, Unit> finishCallback) {
        Intrinsics.checkNotNullParameter(signatureContent, "signatureContent");
        Intrinsics.checkNotNullParameter(signatureTemplates, "signatureTemplates");
        Intrinsics.checkNotNullParameter(finishCallback, "finishCallback");
        this.mSignatureContent = signatureContent;
        this.mSignatureTemplates = signatureTemplates;
        this.mFinishCallback = finishCallback;
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.f27, container);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou\u2026e_edit_dialog, container)");
        this.mRootView = inflate;
        initView();
        vh();
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
        Gh();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Fh();
        Dh();
    }
}
