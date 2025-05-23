package com.tencent.qqguild.directmessage.aio.input.inputbar;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.guild.aio.component.avatar.GuildAioUserAvatarViewBinder;
import com.tencent.guild.aio.input.realinput.t;
import com.tencent.guild.aio.input.realinput.u;
import com.tencent.guild.aio.input.widget.GuildAIOInputEditText;
import com.tencent.guild.aio.input.widget.MutliSeletedBottomLine;
import com.tencent.guild.aio.util.GuildDraftUtil;
import com.tencent.guild.api.emoji.IGuildEmojiApi;
import com.tencent.guild.api.emoji.ISouGouEmoProxyApi;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service.QzoneBaseService;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.emoticon.api.EmojiManagerServiceConstant;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.util.x;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.mvvm.framework.FrameworkVM;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqguild.directmessage.aio.input.GuildC2CPermissions;
import com.tencent.qqguild.directmessage.aio.input.UIState;
import com.tencent.qqguild.directmessage.aio.input.b;
import com.tencent.qqguild.directmessage.aio.input.c;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.util.InputMethodUtil;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 i2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001jB\u0007\u00a2\u0006\u0004\bg\u0010hJ\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\u001c\u0010\r\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\u000e\u001a\u00020\bH\u0002J\b\u0010\u000f\u001a\u00020\bH\u0002J\b\u0010\u0010\u001a\u00020\bH\u0002J\b\u0010\u0011\u001a\u00020\bH\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0012H\u0002J\u0010\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u001cH\u0002J\b\u0010\u001e\u001a\u00020\u0017H\u0002J\u001e\u0010#\u001a\u00020\b2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010\"\u001a\u00020\u0017H\u0002J\u0010\u0010%\u001a\u00020\b2\u0006\u0010$\u001a\u00020\u0012H\u0002J\b\u0010&\u001a\u00020\bH\u0002J\b\u0010'\u001a\u00020\bH\u0002J\u0010\u0010)\u001a\u00020\b2\u0006\u0010(\u001a\u00020\nH\u0002J\u001a\u0010,\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020\u0012H\u0002J\b\u0010.\u001a\u00020-H\u0016J\u0016\u00100\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030/0\u001fH\u0016J\u0010\u00104\u001a\u0002032\u0006\u00102\u001a\u000201H\u0016J\b\u00105\u001a\u00020\bH\u0016J&\u00109\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u000207\u0012\u0006\b\u0001\u0012\u0002080\u00010\u001f2\u0006\u00106\u001a\u000203H\u0016J\b\u0010:\u001a\u00020\bH\u0016J\u0010\u0010;\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0003H\u0016J\u0012\u0010>\u001a\u0004\u0018\u00010\u00052\u0006\u0010=\u001a\u00020<H\u0016J\b\u0010@\u001a\u00020?H\u0016R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u001b\u0010J\u001a\u00020E8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR\u001b\u0010O\u001a\u00020K8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bL\u0010G\u001a\u0004\bM\u0010NR\u0018\u0010R\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010U\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010X\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010\\\u001a\u00020Y8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0014\u0010`\u001a\u00020]8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b^\u0010_R\u0018\u0010d\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010cR\u0018\u0010f\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010c\u00a8\u0006k"}, d2 = {"Lcom/tencent/qqguild/directmessage/aio/input/inputbar/InputBarViewBinder;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/qqguild/directmessage/aio/input/c;", "Lcom/tencent/qqguild/directmessage/aio/input/UIState;", "Lcom/tencent/guild/aio/input/realinput/u;", "Landroid/os/Bundle;", "L1", "M1", "", "u1", "", "action", "data", "U1", "y1", "C1", "r1", "q1", "", "J1", "Lcom/tencent/qqguild/directmessage/aio/input/UIState$ReplyUIState;", "state", "d2", "", "directMessageEnable", "W1", "c2cPermissions", "c2", "Lcom/tencent/qqguild/directmessage/aio/input/UIState$MultiSelectChanged;", ICustomDataEditor.STRING_ARRAY_PARAM_2, "P1", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElements", "showKeyboard", "T1", "selectMediaSize", "S1", "V1", "O1", EmojiManagerServiceConstant.PARAMS_EMOTICON_EID, "K1", "Lcom/tencent/qqguild/directmessage/aio/input/UIState$HintTextUIState;", "tryCount", "X1", "Lcom/tencent/qqguild/directmessage/aio/input/inputbar/InputBarViewModel;", "F1", "Ljava/lang/Class;", "getObserverStates", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "hostView", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "initializeChildVB", "bindViewAndData", "N1", "Lcom/tencent/mvi/api/ability/d;", "stateCmd", "generateVBState", "Lcom/tencent/guild/aio/input/widget/GuildAIOInputEditText;", "H1", "Lvp1/c;", "d", "Lvp1/c;", "binding", "Lcom/tencent/guild/aio/component/avatar/GuildAioUserAvatarViewBinder;", "e", "Lkotlin/Lazy;", Constants.APK_CERTIFICATE, "()Lcom/tencent/guild/aio/component/avatar/GuildAioUserAvatarViewBinder;", "avatarBinder", "Lun0/c;", "f", "I1", "()Lun0/c;", "plusBinder", tl.h.F, "Lcom/tencent/qqguild/directmessage/aio/input/UIState$HintTextUIState;", "hintTextState", "i", "I", "curPermission", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "isMultiSelect", "Lvn0/k;", BdhLogUtil.LogTag.Tag_Conn, "Lvn0/k;", "guildAioReplyLayout", "Landroid/view/View$OnLayoutChangeListener;", "D", "Landroid/view/View$OnLayoutChangeListener;", "mEditOnLayoutListener", "Lcom/tencent/guild/aio/input/widget/MutliSeletedBottomLine;", "E", "Lcom/tencent/guild/aio/input/widget/MutliSeletedBottomLine;", "leftDotLine", UserInfo.SEX_FEMALE, "rightDotLine", "<init>", "()V", "G", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class InputBarViewBinder extends com.tencent.aio.base.mvvm.a<com.tencent.qqguild.directmessage.aio.input.c, UIState> implements u {

    /* renamed from: C, reason: from kotlin metadata */
    private vn0.k guildAioReplyLayout;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final View.OnLayoutChangeListener mEditOnLayoutListener;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private MutliSeletedBottomLine leftDotLine;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private MutliSeletedBottomLine rightDotLine;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private vp1.c binding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy avatarBinder;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy plusBinder;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private UIState.HintTextUIState hintTextState;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int curPermission;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isMultiSelect;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/qqguild/directmessage/aio/input/inputbar/InputBarViewBinder$c", "Lcom/tencent/guild/aio/input/widget/GuildAIOInputEditText$d;", "", "action", "Landroid/os/Bundle;", "data", "", "onPrivateIMECommand", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class c implements GuildAIOInputEditText.d {
        c() {
        }

        @Override // com.tencent.guild.aio.input.widget.GuildAIOInputEditText.d
        public boolean onPrivateIMECommand(@Nullable String action, @Nullable Bundle data) {
            if (InputMethodUtil.checkSogouInputDefault(InputBarViewBinder.this.getMContext())) {
                InputBarViewBinder.this.U1(action, data);
                InputBarViewBinder.this.sendIntent(new c.IMECommandIntent(action, data));
                return true;
            }
            return true;
        }
    }

    public InputBarViewBinder() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GuildAioUserAvatarViewBinder>() { // from class: com.tencent.qqguild.directmessage.aio.input.inputbar.InputBarViewBinder$avatarBinder$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildAioUserAvatarViewBinder invoke() {
                return new GuildAioUserAvatarViewBinder();
            }
        });
        this.avatarBinder = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<un0.c>() { // from class: com.tencent.qqguild.directmessage.aio.input.inputbar.InputBarViewBinder$plusBinder$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final un0.c invoke() {
                return new un0.c();
            }
        });
        this.plusBinder = lazy2;
        this.mEditOnLayoutListener = new View.OnLayoutChangeListener() { // from class: com.tencent.qqguild.directmessage.aio.input.inputbar.m
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
                InputBarViewBinder.Q1(InputBarViewBinder.this, view, i3, i16, i17, i18, i19, i26, i27, i28);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A1(InputBarViewBinder this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendIntent(c.h.f345058d);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B1(InputBarViewBinder this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendIntent(c.j.f345060d);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void C1() {
        vn0.k kVar = this.guildAioReplyLayout;
        vn0.k kVar2 = null;
        if (kVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildAioReplyLayout");
            kVar = null;
        }
        kVar.f441967b.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqguild.directmessage.aio.input.inputbar.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InputBarViewBinder.D1(InputBarViewBinder.this, view);
            }
        });
        vn0.k kVar3 = this.guildAioReplyLayout;
        if (kVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildAioReplyLayout");
        } else {
            kVar2 = kVar3;
        }
        kVar2.f441968c.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqguild.directmessage.aio.input.inputbar.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InputBarViewBinder.E1(InputBarViewBinder.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D1(InputBarViewBinder this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendIntent(c.f.f345056d);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E1(InputBarViewBinder this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendIntent(c.b.f345051d);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final GuildAioUserAvatarViewBinder G1() {
        return (GuildAioUserAvatarViewBinder) this.avatarBinder.getValue();
    }

    private final un0.c I1() {
        return (un0.c) this.plusBinder.getValue();
    }

    private final int J1() {
        GuildSplitViewUtils guildSplitViewUtils = GuildSplitViewUtils.f235370a;
        vp1.c cVar = this.binding;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar = null;
        }
        return guildSplitViewUtils.i(true, cVar.getRoot().getContext());
    }

    private final void K1(String emoticonId) {
        vp1.c cVar = this.binding;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar = null;
        }
        GuildAIOInputEditText guildAIOInputEditText = cVar.f442653g;
        Intrinsics.checkNotNullExpressionValue(guildAIOInputEditText, "binding.guildAioInputEdittext");
        int selectionStart = guildAIOInputEditText.getSelectionStart();
        int selectionEnd = guildAIOInputEditText.getSelectionEnd();
        if (selectionStart >= 0 && selectionEnd >= 0 && selectionEnd >= selectionStart) {
            guildAIOInputEditText.getEditableText().replace(selectionStart, selectionEnd, emoticonId);
            guildAIOInputEditText.requestFocus();
        }
    }

    private final Bundle L1() {
        Bundle bundle = new Bundle();
        vp1.c cVar = this.binding;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar = null;
        }
        bundle.putInt("input_height", cVar.getRoot().getHeight());
        return bundle;
    }

    private final Bundle M1() {
        long j3;
        vp1.c cVar = this.binding;
        vp1.c cVar2 = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar = null;
        }
        Editable editableText = cVar.f442653g.getEditableText();
        vp1.c cVar3 = this.binding;
        if (cVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar3 = null;
        }
        String valueOf = String.valueOf(cVar3.f442653g.getText());
        vn0.k kVar = this.guildAioReplyLayout;
        if (kVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildAioReplyLayout");
            kVar = null;
        }
        String obj = kVar.f441969d.getText().toString();
        vn0.k kVar2 = this.guildAioReplyLayout;
        if (kVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildAioReplyLayout");
            kVar2 = null;
        }
        String obj2 = kVar2.f441970e.getText().toString();
        vp1.c cVar4 = this.binding;
        if (cVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            cVar2 = cVar4;
        }
        LinearLayout linearLayout = cVar2.f442648b;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.aioReply");
        Long l3 = iq0.a.l(linearLayout);
        if (l3 != null) {
            j3 = l3.longValue();
        } else {
            j3 = QzoneBaseService.ERROR_CODE_CLIENT_PARAMS_ERROR;
        }
        Bundle bundle = new Bundle();
        bundle.putString("guild_draft_input_text", valueOf);
        bundle.putCharSequence("guild_draft_input_editable_text", editableText);
        bundle.putLong("guild_draft_input_reply_msg_id", j3);
        bundle.putString("guild_draft_input_reply_nick", obj);
        bundle.putString("guild_draft_input_reply_content", obj2);
        return bundle;
    }

    private final void O1() {
        Logger.f235387a.d().i("Guild.C2C.AIO.GuildAioInput.c2cInputBarVB", 1, "hidePanelAndKeyboard");
        Object systemService = getMContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        vp1.c cVar = this.binding;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar = null;
        }
        inputMethodManager.hideSoftInputFromWindow(cVar.f442653g.getWindowToken(), 0);
    }

    private final boolean P1() {
        if (!this.isMultiSelect && GuildC2CPermissions.INSTANCE.c(this.curPermission)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q1(final InputBarViewBinder this$0, View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        final UIState.HintTextUIState hintTextUIState;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i17 - i3 != i27 - i19 && this$0.I1().e1() && (hintTextUIState = this$0.hintTextState) != null) {
            vp1.c cVar = this$0.binding;
            if (cVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                cVar = null;
            }
            cVar.f442653g.post(new Runnable() { // from class: com.tencent.qqguild.directmessage.aio.input.inputbar.c
                @Override // java.lang.Runnable
                public final void run() {
                    InputBarViewBinder.R1(InputBarViewBinder.this, hintTextUIState);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R1(InputBarViewBinder this$0, UIState.HintTextUIState it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "$it");
        vp1.c cVar = null;
        Y1(this$0, it, 0, 2, null);
        vp1.c cVar2 = this$0.binding;
        if (cVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            cVar = cVar2;
        }
        cVar.f442653g.requestLayout();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0083  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void S1(int selectMediaSize) {
        boolean z16;
        vp1.c cVar;
        QUIButton qUIButton;
        Boolean valueOf;
        boolean isBlank;
        vp1.c cVar2 = this.binding;
        vp1.c cVar3 = null;
        if (cVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar2 = null;
        }
        Editable text = cVar2.f442653g.getText();
        boolean z17 = true;
        if (text != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(text);
            if (!isBlank) {
                z16 = false;
                Logger logger = Logger.f235387a;
                if (QLog.isColorLevel()) {
                    logger.d().d("Guild.C2C.AIO.GuildAioInput.c2cInputBarVB", 2, "refreshSendBtn selectMediaSize=" + selectMediaSize + " isEmpty=" + z16);
                }
                if (z16 || selectMediaSize != 0) {
                    z17 = false;
                }
                I1().h1(z17);
                cVar = this.binding;
                if (cVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    cVar = null;
                }
                qUIButton = cVar.f442661o;
                valueOf = Boolean.valueOf(z17);
                qUIButton.setVisibility(8);
                if (((View) com.tencent.guild.aio.util.ex.g.a(valueOf, qUIButton)) == null) {
                    qUIButton.setVisibility(0);
                }
                if (!z17) {
                    UIState.HintTextUIState hintTextUIState = this.hintTextState;
                    if (hintTextUIState != null) {
                        Y1(this, hintTextUIState, 0, 2, null);
                        return;
                    }
                    return;
                }
                vp1.c cVar4 = this.binding;
                if (cVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    cVar3 = cVar4;
                }
                cVar3.f442653g.setHint("");
                return;
            }
        }
        z16 = true;
        Logger logger2 = Logger.f235387a;
        if (QLog.isColorLevel()) {
        }
        if (z16) {
        }
        z17 = false;
        I1().h1(z17);
        cVar = this.binding;
        if (cVar == null) {
        }
        qUIButton = cVar.f442661o;
        valueOf = Boolean.valueOf(z17);
        qUIButton.setVisibility(8);
        if (((View) com.tencent.guild.aio.util.ex.g.a(valueOf, qUIButton)) == null) {
        }
        if (!z17) {
        }
    }

    private final void T1(List<MsgElement> msgElements, boolean showKeyboard) {
        boolean z16;
        GuildDraftUtil guildDraftUtil = GuildDraftUtil.f112365a;
        vp1.c cVar = this.binding;
        vp1.c cVar2 = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar = null;
        }
        LinearLayout linearLayout = cVar.f442648b;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.aioReply");
        vp1.c cVar3 = this.binding;
        if (cVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar3 = null;
        }
        GuildAIOInputEditText guildAIOInputEditText = cVar3.f442653g;
        Intrinsics.checkNotNullExpressionValue(guildAIOInputEditText, "binding.guildAioInputEdittext");
        guildDraftUtil.c(msgElements, linearLayout, guildAIOInputEditText);
        if (showKeyboard) {
            V1();
        }
        vp1.c cVar4 = this.binding;
        if (cVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            cVar2 = cVar4;
        }
        GuildAIOInputEditText guildAIOInputEditText2 = cVar2.f442653g;
        Intrinsics.checkNotNullExpressionValue(guildAIOInputEditText2, "binding.guildAioInputEdittext");
        Editable text = guildAIOInputEditText2.getText();
        int i3 = 0;
        if (text != null && text.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            Editable text2 = guildAIOInputEditText2.getText();
            if (text2 != null) {
                i3 = text2.length();
            }
            guildAIOInputEditText2.setSelection(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U1(String action, Bundle data) {
        String str;
        InputMethodManager inputMethodManager;
        if (Intrinsics.areEqual(InputMethodUtil.ACTION_SOGOU_APP_ID, action)) {
            vp1.c cVar = null;
            if (data != null) {
                str = data.getString(InputMethodUtil.KEY_SOGOU_APP_ID);
            } else {
                str = null;
            }
            String openId = ((ISouGouEmoProxyApi) QRoute.api(ISouGouEmoProxyApi.class)).getOpenId(getMContext(), str);
            Object systemService = getMContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
            if (systemService instanceof InputMethodManager) {
                inputMethodManager = (InputMethodManager) systemService;
            } else {
                inputMethodManager = null;
            }
            Bundle bundle = new Bundle();
            bundle.putString(InputMethodUtil.KEY_SOGOU_OPEN_ID, openId);
            if (inputMethodManager != null) {
                vp1.c cVar2 = this.binding;
                if (cVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    cVar = cVar2;
                }
                inputMethodManager.sendAppPrivateCommand(cVar.f442653g, InputMethodUtil.ACTION_SOGOU_OPEN_ID, bundle);
            }
        }
    }

    private final void V1() {
        boolean z16;
        vp1.c cVar = this.binding;
        vp1.c cVar2 = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar = null;
        }
        ConstraintLayout constraintLayout = cVar.f442652f;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "binding.guildAioInputBar");
        if (constraintLayout.getVisibility() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return;
        }
        Logger.f235387a.d().i("Guild.C2C.AIO.GuildAioInput.c2cInputBarVB", 1, "showSoftInput");
        vp1.c cVar3 = this.binding;
        if (cVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar3 = null;
        }
        cVar3.f442653g.requestFocus();
        Object systemService = getMContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        vp1.c cVar4 = this.binding;
        if (cVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            cVar2 = cVar4;
        }
        inputMethodManager.showSoftInput(cVar2.f442653g, 0);
    }

    private final void W1(boolean directMessageEnable) {
        int i3;
        vp1.c cVar = this.binding;
        vp1.c cVar2 = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar = null;
        }
        LinearLayout root = cVar.f442650d.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.guildAioDirectMessageBanner.root");
        int i16 = 0;
        if (!directMessageEnable) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        root.setVisibility(i3);
        vp1.c cVar3 = this.binding;
        if (cVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            cVar2 = cVar3;
        }
        ConstraintLayout constraintLayout = cVar2.f442652f;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "binding.guildAioInputBar");
        if (!directMessageEnable) {
            i16 = 8;
        }
        constraintLayout.setVisibility(i16);
        getHostView().requestLayout();
    }

    private final void X1(final UIState.HintTextUIState state, final int tryCount) {
        boolean z16;
        boolean z17;
        this.hintTextState = state;
        vp1.c cVar = this.binding;
        vp1.c cVar2 = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar = null;
        }
        cVar.f442653g.setHint("\u548c " + state.getNickName() + " \u804a\u5929");
        vp1.c cVar3 = this.binding;
        if (cVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar3 = null;
        }
        int width = cVar3.f442653g.getWidth();
        if (width == 0) {
            if (tryCount > 0) {
                vp1.c cVar4 = this.binding;
                if (cVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    cVar2 = cVar4;
                }
                cVar2.f442653g.post(new Runnable() { // from class: com.tencent.qqguild.directmessage.aio.input.inputbar.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        InputBarViewBinder.Z1(InputBarViewBinder.this, state, tryCount);
                    }
                });
                return;
            }
            vp1.c cVar5 = this.binding;
            if (cVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                cVar5 = null;
            }
            FrameLayout root = cVar5.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            boolean z18 = true;
            if (root.getVisibility() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                return;
            }
            vp1.c cVar6 = this.binding;
            if (cVar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                cVar6 = null;
            }
            FrameLayout frameLayout = cVar6.f442656j;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.guildAioRealInputContainer");
            if (frameLayout.getVisibility() == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                return;
            }
            vp1.c cVar7 = this.binding;
            if (cVar7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                cVar7 = null;
            }
            GuildAIOInputEditText guildAIOInputEditText = cVar7.f442653g;
            Intrinsics.checkNotNullExpressionValue(guildAIOInputEditText, "binding.guildAioInputEdittext");
            if (guildAIOInputEditText.getVisibility() != 0) {
                z18 = false;
            }
            if (!z18) {
                return;
            } else {
                com.tencent.mobileqq.guild.util.s.f("Guild.C2C.AIO.GuildAioInput.c2cInputBarVB", "updateHintText: EditText width is 0", new IllegalStateException("editText has no size"));
            }
        }
        vp1.c cVar8 = this.binding;
        if (cVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar8 = null;
        }
        TextPaint paint = cVar8.f442653g.getPaint();
        CharSequence ellipsize = TextUtils.ellipsize(state.getNickName(), paint, width - paint.measureText("\u548c  \u804a\u5929"), TextUtils.TruncateAt.END);
        vp1.c cVar9 = this.binding;
        if (cVar9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            cVar2 = cVar9;
        }
        cVar2.f442653g.setHint("\u548c " + ((Object) ellipsize) + " \u804a\u5929");
    }

    static /* synthetic */ void Y1(InputBarViewBinder inputBarViewBinder, UIState.HintTextUIState hintTextUIState, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 3;
        }
        inputBarViewBinder.X1(hintTextUIState, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z1(InputBarViewBinder this$0, UIState.HintTextUIState state, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(state, "$state");
        this$0.X1(state, i3 - 1);
    }

    private final void a2(UIState.MultiSelectChanged state) {
        int i3;
        Logger.f235387a.d().d("Guild.C2C.AIO.GuildAioInput.c2cInputBarVB", 1, "VB updateMultiSelectVisible isSelect:" + state.getEnable() + " isJubao:" + state.getFromJubao());
        this.isMultiSelect = state.getEnable();
        int i16 = 8;
        vp1.c cVar = null;
        if (state.getFromJubao()) {
            vp1.c cVar2 = this.binding;
            if (cVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                cVar2 = null;
            }
            RelativeLayout relativeLayout = cVar2.f442654h;
            Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.guildAioMultiSelect");
            relativeLayout.setVisibility(8);
            vp1.c cVar3 = this.binding;
            if (cVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                cVar = cVar3;
            }
            FrameLayout root = cVar.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            root.setVisibility(8);
            return;
        }
        vp1.c cVar4 = this.binding;
        if (cVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar4 = null;
        }
        FrameLayout root2 = cVar4.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "binding.root");
        root2.setVisibility(0);
        vp1.c cVar5 = this.binding;
        if (cVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar5 = null;
        }
        FrameLayout frameLayout = cVar5.f442656j;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.guildAioRealInputContainer");
        if (P1()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        frameLayout.setVisibility(i3);
        vp1.c cVar6 = this.binding;
        if (cVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar6 = null;
        }
        RelativeLayout relativeLayout2 = cVar6.f442654h;
        Intrinsics.checkNotNullExpressionValue(relativeLayout2, "binding.guildAioMultiSelect");
        if (state.getEnable()) {
            i16 = 0;
        }
        relativeLayout2.setVisibility(i16);
        vp1.c cVar7 = this.binding;
        if (cVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            cVar = cVar7;
        }
        cVar.f442660n.setText(getMContext().getString(R.string.f139290av, Integer.valueOf(state.getCount())));
    }

    private final void c2(int c2cPermissions) {
        int i3;
        Logger.f235387a.d().d("Guild.C2C.AIO.GuildAioInput.c2cInputBarVB", 1, "VB updateRealInputVisible c2cPermissions:" + c2cPermissions);
        this.curPermission = c2cPermissions;
        vp1.c cVar = this.binding;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar = null;
        }
        FrameLayout frameLayout = cVar.f442656j;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.guildAioRealInputContainer");
        if (P1()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        frameLayout.setVisibility(i3);
    }

    private final void d2(UIState.ReplyUIState state) {
        int i3;
        vp1.c cVar = this.binding;
        vn0.k kVar = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar = null;
        }
        LinearLayout linearLayout = cVar.f442648b;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.aioReply");
        if (state.getVisible()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        linearLayout.setVisibility(i3);
        vn0.k kVar2 = this.guildAioReplyLayout;
        if (kVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildAioReplyLayout");
            kVar2 = null;
        }
        kVar2.f441970e.setText(state.getText());
        if (state.getVisible()) {
            vn0.k kVar3 = this.guildAioReplyLayout;
            if (kVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildAioReplyLayout");
                kVar3 = null;
            }
            kVar3.f441970e.requestFocus();
            vn0.k kVar4 = this.guildAioReplyLayout;
            if (kVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildAioReplyLayout");
            } else {
                kVar = kVar4;
            }
            kVar.f441970e.postDelayed(new Runnable() { // from class: com.tencent.qqguild.directmessage.aio.input.inputbar.d
                @Override // java.lang.Runnable
                public final void run() {
                    InputBarViewBinder.e2(InputBarViewBinder.this);
                }
            }, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e2(InputBarViewBinder this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.V1();
    }

    private final void q1() {
        vp1.c cVar = this.binding;
        vp1.c cVar2 = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar = null;
        }
        cVar.f442654h.removeView(this.leftDotLine);
        vp1.c cVar3 = this.binding;
        if (cVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar3 = null;
        }
        cVar3.f442654h.removeView(this.rightDotLine);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        vp1.c cVar4 = this.binding;
        if (cVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar4 = null;
        }
        cVar4.f442660n.measure(makeMeasureSpec, makeMeasureSpec);
        vp1.c cVar5 = this.binding;
        if (cVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar5 = null;
        }
        int J1 = ((J1() - cVar5.f442660n.getMeasuredWidth()) - x.c(getMContext(), 16.0f)) / 2;
        if (J1 < 0) {
            J1 = 0;
        }
        this.leftDotLine = new MutliSeletedBottomLine(getMContext(), J1, false);
        this.rightDotLine = new MutliSeletedBottomLine(getMContext(), J1, true);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(J1, -2);
        layoutParams.addRule(9);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(J1, -2);
        layoutParams2.addRule(11);
        vp1.c cVar6 = this.binding;
        if (cVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar6 = null;
        }
        cVar6.f442654h.addView(this.leftDotLine, layoutParams);
        vp1.c cVar7 = this.binding;
        if (cVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            cVar2 = cVar7;
        }
        cVar2.f442654h.addView(this.rightDotLine, layoutParams2);
    }

    private final void r1() {
        vp1.c cVar = this.binding;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar = null;
        }
        cVar.f442650d.f442220b.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqguild.directmessage.aio.input.inputbar.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InputBarViewBinder.s1(InputBarViewBinder.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s1(InputBarViewBinder this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendIntent(c.C9364c.f345052d);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void u1() {
        vp1.c cVar = this.binding;
        vp1.c cVar2 = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar = null;
        }
        cVar.f442653g.getInputExtras(true).putInt(InputMethodUtil.FLAG_SOGOU_EXPRESSION, 1);
        vp1.c cVar3 = this.binding;
        if (cVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar3 = null;
        }
        cVar3.f442653g.getInputExtras(true).putInt(InputMethodUtil.SOGOU_EXPRESSION_WEBP, 1);
        vp1.c cVar4 = this.binding;
        if (cVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar4 = null;
        }
        cVar4.f442653g.getInputExtras(true).putInt(InputMethodUtil.SUPPORT_SOGOU_EXPRESSION, 1);
        vp1.c cVar5 = this.binding;
        if (cVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar5 = null;
        }
        cVar5.f442653g.setOnPrivateIMECommandListener(new c());
        vp1.c cVar6 = this.binding;
        if (cVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar6 = null;
        }
        GuildAIOInputEditText guildAIOInputEditText = cVar6.f442653g;
        QRouteApi api = QRoute.api(IGuildEmojiApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IGuildEmojiApi::class.java)");
        guildAIOInputEditText.setEditableFactory(IGuildEmojiApi.a.a((IGuildEmojiApi) api, 18, 0, 2, null));
        vp1.c cVar7 = this.binding;
        if (cVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar7 = null;
        }
        GuildAIOInputEditText guildAIOInputEditText2 = cVar7.f442653g;
        Intrinsics.checkNotNullExpressionValue(guildAIOInputEditText2, "binding.guildAioInputEdittext");
        guildAIOInputEditText2.addTextChangedListener(new b());
        vp1.c cVar8 = this.binding;
        if (cVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar8 = null;
        }
        cVar8.f442661o.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqguild.directmessage.aio.input.inputbar.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InputBarViewBinder.v1(InputBarViewBinder.this, view);
            }
        });
        vp1.c cVar9 = this.binding;
        if (cVar9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar9 = null;
        }
        cVar9.f442653g.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.qqguild.directmessage.aio.input.inputbar.e
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean w16;
                w16 = InputBarViewBinder.w1(InputBarViewBinder.this, view);
                return w16;
            }
        });
        vp1.c cVar10 = this.binding;
        if (cVar10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar10 = null;
        }
        cVar10.f442653g.addOnLayoutChangeListener(this.mEditOnLayoutListener);
        vp1.c cVar11 = this.binding;
        if (cVar11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            cVar2 = cVar11;
        }
        cVar2.f442653g.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.qqguild.directmessage.aio.input.inputbar.f
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean x16;
                x16 = InputBarViewBinder.x1(InputBarViewBinder.this, view, motionEvent);
                return x16;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v1(InputBarViewBinder this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!com.tencent.mobileqq.guild.util.o.c("fastClickGuard")) {
            this$0.sendIntent(c.a.f345050d);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean w1(InputBarViewBinder this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.guild.util.m mVar = com.tencent.mobileqq.guild.util.m.f235570a;
        vp1.c cVar = this$0.binding;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar = null;
        }
        mVar.a("dm-aio-edit-hint", cVar.f442653g.getHintTextColors());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean x1(InputBarViewBinder this$0, View view, MotionEvent motionEvent) {
        FrameworkVM mUIModel;
        com.tencent.aio.api.runtime.a aVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (motionEvent.getAction() != 0 || (mUIModel = this$0.getMUIModel()) == null || (aVar = (com.tencent.aio.api.runtime.a) mUIModel.getMContext()) == null || !com.tencent.guild.aio.util.d.a(aVar)) {
            return false;
        }
        return true;
    }

    private final void y1() {
        vp1.c cVar = this.binding;
        vp1.c cVar2 = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar = null;
        }
        cVar.f442659m.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqguild.directmessage.aio.input.inputbar.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InputBarViewBinder.z1(InputBarViewBinder.this, view);
            }
        });
        vp1.c cVar3 = this.binding;
        if (cVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar3 = null;
        }
        cVar3.f442658l.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqguild.directmessage.aio.input.inputbar.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InputBarViewBinder.A1(InputBarViewBinder.this, view);
            }
        });
        vp1.c cVar4 = this.binding;
        if (cVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            cVar2 = cVar4;
        }
        cVar2.f442660n.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqguild.directmessage.aio.input.inputbar.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InputBarViewBinder.B1(InputBarViewBinder.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z1(InputBarViewBinder this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendIntent(c.i.f345059d);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: F1, reason: merged with bridge method [inline-methods] */
    public InputBarViewModel getViewModel() {
        return new InputBarViewModel(this);
    }

    @Override // com.tencent.guild.aio.input.realinput.u
    @NotNull
    /* renamed from: H1, reason: merged with bridge method [inline-methods] */
    public GuildAIOInputEditText g() {
        vp1.c cVar = this.binding;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar = null;
        }
        GuildAIOInputEditText guildAIOInputEditText = cVar.f442653g;
        Intrinsics.checkNotNullExpressionValue(guildAIOInputEditText, "binding.guildAioInputEdittext");
        return guildAIOInputEditText;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: N1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull UIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        Logger.f235387a.d().i("Guild.C2C.AIO.GuildAioInput.c2cInputBarVB", 1, "handleUiState: " + state);
        if (state instanceof UIState.HidePanelAndKeyboardUIState) {
            O1();
            return;
        }
        vp1.c cVar = null;
        if (state instanceof UIState.ClearEditInputUIState) {
            vp1.c cVar2 = this.binding;
            if (cVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                cVar = cVar2;
            }
            cVar.f442653g.getEditableText().clear();
            return;
        }
        if (state instanceof UIState.AddEmoticonUIState) {
            K1(((UIState.AddEmoticonUIState) state).getEmoticonCode());
            return;
        }
        if (state instanceof UIState.ShowSoftKeyboard) {
            V1();
            return;
        }
        if (state instanceof UIState.DirectMessageSwitch) {
            W1(((UIState.DirectMessageSwitch) state).getEnable());
            return;
        }
        if (state instanceof UIState.GuildHandlerPermissionsChange) {
            c2(((UIState.GuildHandlerPermissionsChange) state).getPermissions());
            return;
        }
        if (state instanceof UIState.HintTextUIState) {
            Y1(this, (UIState.HintTextUIState) state, 0, 2, null);
            return;
        }
        if (state instanceof UIState.ReplyUIState) {
            d2((UIState.ReplyUIState) state);
            return;
        }
        if (state instanceof UIState.MultiSelectChanged) {
            a2((UIState.MultiSelectChanged) state);
            return;
        }
        if (state instanceof UIState.RecoverDraft) {
            UIState.RecoverDraft recoverDraft = (UIState.RecoverDraft) state;
            T1(recoverDraft.b(), recoverDraft.getShowKeyboard());
        } else if (state instanceof UIState.RefreshSendBtn) {
            S1(((UIState.RefreshSendBtn) state).getSelectedMediaCount());
        } else if (state instanceof UIState.ConfigurationChanged) {
            q1();
        }
    }

    @Override // com.tencent.guild.aio.input.realinput.u
    public int b() {
        return u.a.a(this);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        sendIntent(c.e.f345055d);
        vp1.c cVar = this.binding;
        vp1.c cVar2 = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar = null;
        }
        ConstraintLayout constraintLayout = cVar.f442652f;
        com.tencent.guild.aio.input.realinput.s sVar = com.tencent.guild.aio.input.realinput.s.f111173a;
        constraintLayout.setBackgroundResource(sVar.a());
        vp1.c cVar3 = this.binding;
        if (cVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar3 = null;
        }
        cVar3.f442652f.setPadding(0, 0, 0, 0);
        vp1.c cVar4 = this.binding;
        if (cVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar4 = null;
        }
        cVar4.f442653g.setTextColor(sVar.b(getMContext()));
        com.tencent.guild.aio.util.g gVar = com.tencent.guild.aio.util.g.f112400a;
        vp1.c cVar5 = this.binding;
        if (cVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            cVar2 = cVar5;
        }
        GuildAIOInputEditText guildAIOInputEditText = cVar2.f442653g;
        Intrinsics.checkNotNullExpressionValue(guildAIOInputEditText, "binding.guildAioInputEdittext");
        gVar.c(guildAIOInputEditText, new Function0<Unit>() { // from class: com.tencent.qqguild.directmessage.aio.input.inputbar.InputBarViewBinder$bindViewAndData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                vp1.c cVar6;
                cVar6 = InputBarViewBinder.this.binding;
                if (cVar6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    cVar6 = null;
                }
                cVar6.f442661o.performClick();
            }
        });
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.api.ability.c
    @Nullable
    public Bundle generateVBState(@NotNull com.tencent.mvi.api.ability.d stateCmd) {
        Intrinsics.checkNotNullParameter(stateCmd, "stateCmd");
        if (stateCmd instanceof t.a) {
            return M1();
        }
        if (stateCmd instanceof b.a) {
            return L1();
        }
        return super.generateVBState(stateCmd);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<Class<? extends UIState>> getObserverStates() {
        return UIState.INSTANCE.a();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>> initializeChildVB(@NotNull View hostView) {
        List<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>> listOf;
        Intrinsics.checkNotNullParameter(hostView, "hostView");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.aio.base.mvvm.a[]{G1(), new tn0.c(), new com.tencent.guild.aio.component.album.c(), I1(), new go0.e()});
        return listOf;
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        vp1.c g16 = vp1.c.g(LayoutInflater.from(createViewParams.a()), createViewParams.b(), false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(\n            inf\u2026          false\n        )");
        this.binding = g16;
        vp1.c cVar = null;
        if (g16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            g16 = null;
        }
        vn0.k e16 = vn0.k.e(g16.getRoot());
        Intrinsics.checkNotNullExpressionValue(e16, "bind(binding.root)");
        this.guildAioReplyLayout = e16;
        u1();
        y1();
        C1();
        r1();
        q1();
        vp1.c cVar2 = this.binding;
        if (cVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            cVar = cVar2;
        }
        FrameLayout root = cVar.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        super.onDestroy();
        O1();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J*\u0010\f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016J*\u0010\u000e\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\u000f\u00b8\u0006\u0000"}, d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "Landroid/text/Editable;", ReportConstant.COSTREPORT_PREFIX, "", "afterTextChanged", "", "text", "", "start", "count", "after", "beforeTextChanged", "before", "onTextChanged", "core-ktx_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable s16) {
            InputBarViewBinder.this.sendIntent(c.g.f345057d);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence text, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence text, int start, int before, int count) {
        }
    }
}
