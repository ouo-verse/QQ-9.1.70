package com.tencent.mobileqq.guild.media.content;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.projection.MediaProjectionManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.media.chat.view.GuildMediaChatAnchorFullView;
import com.tencent.mobileqq.guild.media.chat.view.GuildMediaChatAudienceFullView;
import com.tencent.mobileqq.guild.media.chat.view.GuildMediaChatNormalView;
import com.tencent.mobileqq.guild.media.chat.view.j;
import com.tencent.mobileqq.guild.media.core.logic.s;
import com.tencent.mobileqq.guild.media.core.logic.trtc.TRTCAudioRoomLocalNew;
import com.tencent.mobileqq.guild.media.core.notify.ScreenShareActionEvent;
import com.tencent.mobileqq.guild.media.core.notify.SwitchScreenState;
import com.tencent.mobileqq.guild.media.core.notify.o;
import com.tencent.mobileqq.guild.media.core.notify.p;
import com.tencent.mobileqq.guild.media.screenshare.view.ScreenShareSecurityTipDialog;
import com.tencent.mobileqq.guild.performance.report.aa;
import com.tencent.mobileqq.guild.util.bw;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProUserAVRspInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.fc;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import wh2.er;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 K2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001LB\u0007\u00a2\u0006\u0004\bI\u0010JJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\bH\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\b\u0010\u0015\u001a\u00020\bH\u0002J\u0018\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0011H\u0002J\b\u0010\u001a\u001a\u00020\u0004H\u0002J\u0016\u0010\u001d\u001a\u00020\u00042\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u001bH\u0002J(\u0010 \u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u00112\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u001bH\u0002J\u0012\u0010!\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010#\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\bH\u0002J\b\u0010%\u001a\u00020$H\u0002J\b\u0010&\u001a\u00020\u0004H\u0002J&\u0010.\u001a\u0004\u0018\u00010-2\u0006\u0010(\u001a\u00020'2\b\u0010*\u001a\u0004\u0018\u00010)2\b\u0010,\u001a\u0004\u0018\u00010+H\u0016J\u001a\u00100\u001a\u00020\u00042\u0006\u0010/\u001a\u00020-2\b\u0010,\u001a\u0004\u0018\u00010+H\u0016J\b\u00101\u001a\u00020\u0004H\u0016J\"\u00106\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u000f2\u0006\u00103\u001a\u00020\u000f2\b\u00105\u001a\u0004\u0018\u000104H\u0016J\u0010\u00108\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u0003H\u0016J\b\u00109\u001a\u00020\bH\u0016J\b\u0010:\u001a\u00020\bH\u0016J\b\u0010;\u001a\u00020\bH\u0016J\b\u0010<\u001a\u00020\bH\u0016J\u0006\u0010=\u001a\u00020\bR\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010D\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bF\u0010G\u00a8\u0006M"}, d2 = {"Lcom/tencent/mobileqq/guild/media/content/GuildMediaChatContent;", "Lcom/tencent/mobileqq/guild/media/content/GuildMediaContentFragmentBase;", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/an;", "", "Qh", "hi", "Rh", "", "toStartScreenShare", "Zh", "ai", "Ih", "Hh", "ii", "", "resCode", "", "errMsg", "bi", "fi", "Wh", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProSecurityResult;", "security", "key", "Nh", "Lh", "Lkotlin/Function0;", "onSuccess", "ki", "reason", "onConfirm", "ci", "Mh", "toFullScreenType", "gi", "Lcom/tencent/mobileqq/guild/media/chat/view/j;", "Kh", "Jh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onDestroyView", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "event", "Yh", "C0", "rh", "kd", "J2", "Xh", "Landroid/widget/FrameLayout;", "E", "Landroid/widget/FrameLayout;", "mChatSubViewContainer", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/media/chat/view/j;", "mChatSubView", "Lrs1/a;", "G", "Lrs1/a;", "mChatViewModel", "<init>", "()V", "H", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildMediaChatContent extends GuildMediaContentFragmentBase implements o<ScreenShareActionEvent> {

    /* renamed from: E, reason: from kotlin metadata */
    private FrameLayout mChatSubViewContainer;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private j mChatSubView;

    /* renamed from: G, reason: from kotlin metadata */
    private rs1.a mChatViewModel;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f228000a;

        static {
            int[] iArr = new int[SwitchScreenState.values().length];
            try {
                iArr[SwitchScreenState.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SwitchScreenState.FULL_LAND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SwitchScreenState.FULL_VERTICAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f228000a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/content/GuildMediaChatContent$c", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "event", "", "D0", "(Ljava/lang/Object;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements o<SwitchScreenState> {
        public c() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        public void D0(SwitchScreenState event) {
            int i3 = b.f228000a[event.ordinal()];
            rs1.a aVar = null;
            if (i3 != 1) {
                if (i3 == 2) {
                    rs1.a aVar2 = GuildMediaChatContent.this.mChatViewModel;
                    if (aVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mChatViewModel");
                    } else {
                        aVar = aVar2;
                    }
                    aVar.P1().setValue(Boolean.TRUE);
                    return;
                }
                if (i3 == 3) {
                    rs1.a aVar3 = GuildMediaChatContent.this.mChatViewModel;
                    if (aVar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mChatViewModel");
                    } else {
                        aVar = aVar3;
                    }
                    aVar.O1().setValue(Boolean.TRUE);
                    return;
                }
                return;
            }
            if (!(GuildMediaChatContent.this.mChatSubView instanceof GuildMediaChatNormalView)) {
                rs1.a aVar4 = GuildMediaChatContent.this.mChatViewModel;
                if (aVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mChatViewModel");
                } else {
                    aVar = aVar4;
                }
                aVar.N1().setValue(Boolean.TRUE);
            }
        }
    }

    private final boolean Hh() {
        QLog.i("QGMC.GuildMediaChatContent", 1, "[checkSelfMute] ");
        if (com.tencent.mobileqq.guild.media.core.j.a().S().d0()) {
            String w3 = com.tencent.mobileqq.guild.setting.mute.c.w(com.tencent.mobileqq.guild.media.core.j.a().getGuildID(), com.tencent.mobileqq.guild.media.core.j.a().E());
            if (!TextUtils.isEmpty(w3)) {
                QLog.i("QGMC.GuildMediaChatContent", 1, "[checkSelfMute] " + w3);
                bi(0, w3);
                return false;
            }
        }
        return true;
    }

    private final boolean Ih() {
        QLog.i("QGMC.GuildMediaChatContent", 1, "[checkSpeakPermission] ");
        if (!com.tencent.mobileqq.guild.media.core.j.a().S().i0()) {
            return true;
        }
        String guildID = com.tencent.mobileqq.guild.media.core.j.a().getGuildID();
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        sz1.c.d(requireActivity, guildID);
        return false;
    }

    private final void Jh() {
        j jVar = this.mChatSubView;
        if (jVar != null) {
            jVar.F0();
        }
        FrameLayout frameLayout = this.mChatSubViewContainer;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatSubViewContainer");
            frameLayout = null;
        }
        frameLayout.removeAllViews();
    }

    private final j Kh() {
        rs1.a aVar = this.mChatViewModel;
        AttributeSet attributeSet = null;
        byte b16 = 0;
        byte b17 = 0;
        byte b18 = 0;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatViewModel");
            aVar = null;
        }
        int i3 = 2;
        if (aVar.R1()) {
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            return new GuildMediaChatAnchorFullView(requireContext, attributeSet, i3, b18 == true ? 1 : 0);
        }
        Context requireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext()");
        return new GuildMediaChatAudienceFullView(requireContext2, b17 == true ? 1 : 0, i3, b16 == true ? 1 : 0);
    }

    private final void Lh() {
        ki(new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.media.content.GuildMediaChatContent$getSharePermissionAndJump$1
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
                boolean Wh;
                Wh = GuildMediaChatContent.this.Wh();
                if (Wh) {
                    return;
                }
                QLog.i("QGMC.GuildMediaChatContent", 1, "[getSharePermissionAndJump] ");
                Object systemService = GuildMediaChatContent.this.requireContext().getSystemService("media_projection");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.projection.MediaProjectionManager");
                Intent createScreenCaptureIntent = ((MediaProjectionManager) systemService).createScreenCaptureIntent();
                if (!GuildMediaChatContent.this.isAdded()) {
                    com.tencent.mobileqq.guild.safety.j.d("QGMC.GuildMediaChatContent", "handleShareScreen | fragment not added");
                } else {
                    GuildMediaChatContent.this.startActivityForResult(createScreenCaptureIntent, 1002);
                }
            }
        });
    }

    private final String Mh(IGProSecurityResult security) {
        try {
            String optString = new JSONObject(security.getStrDetail()).optString("verify_url");
            if (!URLUtil.isValidUrl(optString)) {
                return null;
            }
            return optString;
        } catch (Exception e16) {
            QLog.d("QGMC.GuildMediaChatContent", 1, e16, new Object[0]);
            return null;
        }
    }

    private final void Nh(IGProSecurityResult security, String key) {
        final String Mh;
        QLog.i("QGMC.GuildMediaChatContent", 1, "[handlerWithResult] action: " + security.get$actionCode() + ", prompt: " + security.getStrPrompt());
        long j3 = security.get$actionCode();
        if (j3 == 102) {
            final QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
            if (qBaseActivity != null && !qBaseActivity.isFinishing() && (Mh = Mh(security)) != null) {
                QLog.i("QGMC.GuildMediaChatContent", 1, "[handlerWithResult] show certification dialog. url: " + Mh);
                DialogUtil.createCustomDialog(qBaseActivity, 230, (String) null, security.getStrPrompt(), qBaseActivity.getString(R.string.f140850f3), qBaseActivity.getString(R.string.f147880y3), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.content.g
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        GuildMediaChatContent.Oh(QBaseActivity.this, Mh, dialogInterface, i3);
                    }
                }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.content.h
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        GuildMediaChatContent.Ph(dialogInterface, i3);
                    }
                }).show();
                return;
            }
            return;
        }
        if (j3 == 0) {
            com.tencent.mobileqq.guild.media.core.j.a().W().a(key);
            return;
        }
        String strPrompt = security.getStrPrompt();
        Intrinsics.checkNotNullExpressionValue(strPrompt, "security.strPrompt");
        QQToast.makeText(getContext(), 1, strPrompt, 1).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oh(QBaseActivity qBaseActivity, String str, DialogInterface dialogInterface, int i3) {
        ch.i1(qBaseActivity, str);
    }

    private final void Qh() {
        com.tencent.mobileqq.guild.media.core.j.d().V(ScreenShareActionEvent.class, this);
        p d16 = com.tencent.mobileqq.guild.media.core.j.d();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        d16.k0(viewLifecycleOwner, SwitchScreenState.class, new c());
        Rh();
    }

    private final void Rh() {
        rs1.a aVar = this.mChatViewModel;
        rs1.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatViewModel");
            aVar = null;
        }
        aVar.O1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.media.content.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildMediaChatContent.Sh(GuildMediaChatContent.this, (Boolean) obj);
            }
        });
        rs1.a aVar3 = this.mChatViewModel;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatViewModel");
            aVar3 = null;
        }
        aVar3.N1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.media.content.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildMediaChatContent.Th(GuildMediaChatContent.this, (Boolean) obj);
            }
        });
        rs1.a aVar4 = this.mChatViewModel;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatViewModel");
            aVar4 = null;
        }
        aVar4.M1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.media.content.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildMediaChatContent.Uh(GuildMediaChatContent.this, (String) obj);
            }
        });
        rs1.a aVar5 = this.mChatViewModel;
        if (aVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatViewModel");
        } else {
            aVar2 = aVar5;
        }
        aVar2.P1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.media.content.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildMediaChatContent.Vh(GuildMediaChatContent.this, (Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Sh(GuildMediaChatContent this$0, Boolean bool) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("QGMC.GuildMediaChatContent", 1, "[initViewObserver] toExpand");
        this$0.gi(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Th(GuildMediaChatContent this$0, Boolean bool) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("QGMC.GuildMediaChatContent", 1, "[initViewObserver] toCollapse");
        this$0.gi(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Uh(GuildMediaChatContent this$0, String str) {
        boolean isBlank;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean z16 = true;
        QLog.i("QGMC.GuildMediaChatContent", 1, "[initViewObserver] id: " + str);
        if (str != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank) {
                z16 = false;
            }
        }
        if (z16) {
            this$0.gi(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Vh(GuildMediaChatContent this$0, Boolean bool) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ph().a2().postValue(bool);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean Wh() {
        boolean z16;
        boolean z17;
        if (getContext() == null || getActivity() == null) {
            return true;
        }
        FragmentActivity activity = getActivity();
        if (activity != null && activity.isFinishing()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return true;
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null && activity2.isDestroyed()) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            return true;
        }
        return false;
    }

    private final void Zh(boolean toStartScreenShare) {
        QLog.i("QGMC.GuildMediaChatContent", 1, "[onScreenShareStateChanged] " + toStartScreenShare);
        if (toStartScreenShare) {
            Lh();
        } else {
            fi();
        }
    }

    private final void ai() {
        QLog.i("QGMC.GuildMediaChatContent", 1, "[openScreenShare] ");
        if (!Ih() || !Hh()) {
            return;
        }
        ii();
    }

    private final void bi(int resCode, String errMsg) {
        if (resCode == 20004) {
            QQToast.makeText(getContext(), errMsg, 0).show();
        } else {
            di(this, resCode, errMsg, null, 4, null);
        }
    }

    private final void ci(int resCode, String reason, final Function0<Unit> onConfirm) {
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
            DialogUtil.createCustomDialog(qBaseActivity, 230, (String) null, reason, (String) null, qBaseActivity.getString(R.string.f146610un), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.content.f
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    GuildMediaChatContent.ei(Function0.this, dialogInterface, i3);
                }
            }, (DialogInterface.OnClickListener) null).show();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void di(GuildMediaChatContent guildMediaChatContent, int i3, String str, Function0 function0, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            function0 = new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.media.content.GuildMediaChatContent$showOneBtnDialog$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        guildMediaChatContent.ci(i3, str, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ei(Function0 onConfirm, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(onConfirm, "$onConfirm");
        onConfirm.invoke();
    }

    private final void fi() {
        aa.f230980i.u(false, 0, "");
        com.tencent.mobileqq.guild.media.core.j.a().W().d(true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0085, code lost:
    
        if (r7.R1() == false) goto L21;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void gi(boolean toFullScreenType) {
        j Kh;
        rs1.a aVar = this.mChatViewModel;
        rs1.a aVar2 = null;
        byte b16 = 0;
        byte b17 = 0;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatViewModel");
            aVar = null;
        }
        boolean z16 = true;
        QLog.i("QGMC.GuildMediaChatContent", 1, "[switchSubView] full: " + toFullScreenType + ", anchor: " + aVar.R1());
        ph().b2().setValue(Boolean.valueOf(toFullScreenType));
        Jh();
        if (!toFullScreenType) {
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            Kh = new GuildMediaChatNormalView(requireContext, b17 == true ? 1 : 0, 2, b16 == true ? 1 : 0);
        } else {
            Kh = Kh();
        }
        this.mChatSubView = Kh;
        if (toFullScreenType) {
            com.tencent.mobileqq.guild.media.core.j.a().M0().Q0(false);
        } else {
            com.tencent.mobileqq.guild.media.core.j.a().M0().Q0(true);
        }
        if (toFullScreenType) {
            rs1.a aVar3 = this.mChatViewModel;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mChatViewModel");
                aVar3 = null;
            }
        }
        z16 = false;
        ph().c2().setValue(Boolean.valueOf(z16));
        ph().Q1().setValue(Boolean.valueOf(rh()));
        FrameLayout frameLayout = this.mChatSubViewContainer;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatSubViewContainer");
            frameLayout = null;
        }
        j jVar = this.mChatSubView;
        Intrinsics.checkNotNull(jVar, "null cannot be cast to non-null type android.view.ViewGroup");
        frameLayout.addView((ViewGroup) jVar);
        j jVar2 = this.mChatSubView;
        if (jVar2 != null) {
            IGProGuildInfo guildInfo = ph().getGuildInfo();
            IGProChannelInfo channelInfo = ph().getChannelInfo();
            rs1.a aVar4 = this.mChatViewModel;
            if (aVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mChatViewModel");
            } else {
                aVar2 = aVar4;
            }
            jVar2.E0(guildInfo, channelInfo, aVar2, this);
        }
    }

    private final void hi() {
        com.tencent.mobileqq.guild.media.core.j.d().j(ScreenShareActionEvent.class, this);
    }

    private final void ii() {
        IGPSService iGPSService = (IGPSService) ch.R0(IGPSService.class);
        fc fcVar = new fc();
        fcVar.a().e(Long.parseLong(com.tencent.mobileqq.guild.media.core.j.a().getGuildID()));
        fcVar.a().d(Long.parseLong(com.tencent.mobileqq.guild.media.core.j.a().E()));
        String f16 = ch.f();
        Intrinsics.checkNotNullExpressionValue(f16, "accountTinyId()");
        fcVar.g(Long.parseLong(f16));
        fcVar.b().f(12);
        iGPSService.userShareScreen(fcVar, new er() { // from class: com.tencent.mobileqq.guild.media.content.e
            @Override // wh2.er
            public final void a(int i3, String str, IGProUserAVRspInfo iGProUserAVRspInfo) {
                GuildMediaChatContent.ji(GuildMediaChatContent.this, i3, str, iGProUserAVRspInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ji(GuildMediaChatContent this$0, int i3, String errMsg, IGProUserAVRspInfo iGProUserAVRspInfo) {
        IGProSecurityResult iGProSecurityResult;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        aa aaVar = aa.f230980i;
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        aaVar.u(true, i3, errMsg);
        IGProChannelInfo channelInfo = this$0.ph().getChannelInfo();
        QLog.i("QGMC.GuildMediaChatContent", 1, "[openScreenShare] userHandUp, " + channelInfo.getGuildId() + " " + channelInfo.getChannelUin() + ", result: [" + i3 + ", " + errMsg + "]");
        if (i3 != 0) {
            this$0.bi(i3, errMsg);
            return;
        }
        if (iGProUserAVRspInfo != null) {
            iGProSecurityResult = iGProUserAVRspInfo.getSecResult();
        } else {
            iGProSecurityResult = null;
        }
        if (iGProSecurityResult != null) {
            IGProSecurityResult secResult = iGProUserAVRspInfo.getSecResult();
            Intrinsics.checkNotNullExpressionValue(secResult, "rspInfo.secResult");
            String trtcKey = iGProUserAVRspInfo.getTrtcKey();
            Intrinsics.checkNotNullExpressionValue(trtcKey, "rspInfo.trtcKey");
            this$0.Nh(secResult, trtcKey);
            return;
        }
        s W = com.tencent.mobileqq.guild.media.core.j.a().W();
        String trtcKey2 = iGProUserAVRspInfo.getTrtcKey();
        Intrinsics.checkNotNullExpressionValue(trtcKey2, "rspInfo.trtcKey");
        W.a(trtcKey2);
    }

    private final void ki(final Function0<Unit> onSuccess) {
        if (bw.L().decodeBool("dont_show_guild_screen_share_tips", false)) {
            onSuccess.invoke();
            return;
        }
        ScreenShareSecurityTipDialog screenShareSecurityTipDialog = new ScreenShareSecurityTipDialog(new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.media.content.GuildMediaChatContent$withTipConfirm$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                onSuccess.invoke();
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        });
        FragmentManager supportFragmentManager = requireActivity().getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "requireActivity().supportFragmentManager");
        com.tencent.mobileqq.guild.base.extension.d.a(screenShareSecurityTipDialog, supportFragmentManager, "QGMC.GuildMediaChatContent");
    }

    @Override // com.tencent.mobileqq.guild.media.content.GuildMediaContentFragmentBase, com.tencent.mobileqq.guild.media.content.i
    public boolean C0() {
        j jVar = this.mChatSubView;
        if (jVar != null) {
            return jVar.C0();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.media.content.GuildMediaContentFragmentBase, com.tencent.mobileqq.guild.media.content.i
    public boolean J2() {
        j jVar = this.mChatSubView;
        if (!(jVar instanceof GuildMediaChatAnchorFullView) && !(jVar instanceof GuildMediaChatAudienceFullView)) {
            return false;
        }
        return true;
    }

    public final boolean Xh() {
        return this.mChatSubView instanceof GuildMediaChatAudienceFullView;
    }

    @Override // com.tencent.mobileqq.guild.media.core.notify.o
    /* renamed from: Yh, reason: merged with bridge method [inline-methods] */
    public void D0(@NotNull ScreenShareActionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        QLog.i("QGMC.GuildMediaChatContent", 1, "[onEventReceive] " + event.getToStartScreenShare());
        Zh(event.getToStartScreenShare());
    }

    @Override // com.tencent.mobileqq.guild.media.content.GuildMediaContentFragmentBase, com.tencent.mobileqq.guild.media.content.i
    public boolean kd() {
        j jVar = this.mChatSubView;
        if (jVar instanceof GuildMediaChatNormalView) {
            Intrinsics.checkNotNull(jVar, "null cannot be cast to non-null type com.tencent.mobileqq.guild.media.chat.view.GuildMediaChatNormalView");
            return ((GuildMediaChatNormalView) jVar).d();
        }
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (FastClickUtils.isFastDoubleClick("QGMC.GuildMediaChatContent")) {
            QLog.d("QGMC.GuildMediaChatContent", 4, "[onActivityResult] isFastDoubleClick");
            return;
        }
        QLog.i("QGMC.GuildMediaChatContent", 1, "[onActivityResult] " + requestCode + ", " + resultCode);
        if (requestCode == 1002 && resultCode == -1) {
            TRTCAudioRoomLocalNew.INSTANCE.c(data);
            ai();
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FrameLayout frameLayout = new FrameLayout(requireContext());
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.mChatSubViewContainer = frameLayout;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, frameLayout);
        return frameLayout;
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        hi();
        rs1.a aVar = this.mChatViewModel;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatViewModel");
            aVar = null;
        }
        aVar.T1();
        Jh();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ViewModel viewModel = new ViewModelProvider(this).get(rs1.a.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this)[\u2026hatViewModel::class.java]");
        this.mChatViewModel = (rs1.a) viewModel;
        gi(false);
        rs1.a aVar = this.mChatViewModel;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatViewModel");
            aVar = null;
        }
        aVar.init();
        Qh();
    }

    @Override // com.tencent.mobileqq.guild.media.content.GuildMediaContentFragmentBase
    public boolean rh() {
        j jVar = this.mChatSubView;
        if (jVar != null) {
            return jVar.D0();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ph(DialogInterface dialogInterface, int i3) {
    }
}
