package com.tencent.mobileqq.guild.setting.guildsetting.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.base.QQGuildTokenTitleBarFragment;
import com.tencent.mobileqq.guild.common.upload.GuildCgiUploader;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedMiscApi;
import com.tencent.mobileqq.guild.nt.misc.api.IUploadApi;
import com.tencent.mobileqq.guild.profile.me.aj;
import com.tencent.mobileqq.guild.setting.guildsetting.data.UpdateUserInfoEvent;
import com.tencent.mobileqq.guild.setting.guildsetting.viewmodel.GuildModifyMemberInfoViewModel;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt;
import com.tencent.mobileqq.guild.widget.PressDarkImageView;
import com.tencent.mobileqq.guild.widget.RadiusFrameLayout;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.ev;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.inputview.QUISingleLineInputView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.util.LoadingUtil;
import com.tencent.util.QQToastUtil;
import com.tencent.util.UiThreadUtil;
import cooperation.qzone.QzoneIPCModule;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wh2.dv;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 [2\u00020\u0001:\u0001\\B\u0007\u00a2\u0006\u0004\bY\u0010ZJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u001a\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0006\u0010\n\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\bJ\"\u0010\u0010\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0006\u0010\u0011\u001a\u00020\bJ\b\u0010\u0012\u001a\u00020\bH\u0016J\b\u0010\u0013\u001a\u00020\bH\u0002J\b\u0010\u0014\u001a\u00020\bH\u0002J\b\u0010\u0015\u001a\u00020\bH\u0002J\b\u0010\u0016\u001a\u00020\bH\u0002J\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J \u0010\u001e\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J \u0010\u001f\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010!\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u0017H\u0002J\b\u0010\"\u001a\u00020\bH\u0002J\u0010\u0010$\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u0017H\u0002J\u0010\u0010%\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J,\u0010+\u001a\u00020\b2\u0006\u0010&\u001a\u00020\u00022\b\u0010'\u001a\u0004\u0018\u00010\u00172\b\u0010)\u001a\u0004\u0018\u00010(2\u0006\u0010*\u001a\u00020\u0002H\u0002J\b\u0010,\u001a\u00020\bH\u0002J\b\u0010-\u001a\u00020\bH\u0002J\b\u0010.\u001a\u00020\bH\u0002R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010E\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010G\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010DR\u0016\u0010#\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010DR\u0014\u0010L\u001a\u00020I8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010P\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010T\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0014\u0010X\u001a\u00020U8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bV\u0010W\u00a8\u0006]"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildsetting/fragment/GuildModifyMemberNameAndAvatarFragment;", "Lcom/tencent/mobileqq/guild/base/QQGuildTokenTitleBarFragment;", "", "getContentLayoutId", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "initView", "initData", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "fi", "rh", "ai", "ri", "pi", "Zh", "", "path", "Vh", "Lcom/tencent/mobileqq/guild/nt/misc/api/IUploadApi$c;", "task", "Lcom/tencent/mobileqq/guild/nt/misc/api/IUploadApi$d;", "state", "hi", "ii", "url", "si", "mi", "uploadPath", "ti", "li", "result", "errMsg", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProSecurityResult;", "security", "type", "Uh", "oi", "ni", "ei", "Landroid/widget/ImageView;", "T", "Landroid/widget/ImageView;", "mCameraIcon", "Lcom/tencent/mobileqq/widget/inputview/QUISingleLineInputView;", "U", "Lcom/tencent/mobileqq/widget/inputview/QUISingleLineInputView;", "mInputView", "Lcom/tencent/mobileqq/guild/widget/RadiusFrameLayout;", "V", "Lcom/tencent/mobileqq/guild/widget/RadiusFrameLayout;", "mGuildAvatarLayout", "Lcom/tencent/mobileqq/guild/widget/PressDarkImageView;", "W", "Lcom/tencent/mobileqq/guild/widget/PressDarkImageView;", "mGuildUserAvatar", "Lcom/tencent/mobileqq/guild/setting/guildsetting/viewmodel/GuildModifyMemberInfoViewModel;", "X", "Lcom/tencent/mobileqq/guild/setting/guildsetting/viewmodel/GuildModifyMemberInfoViewModel;", "viewModel", "Y", "Ljava/lang/String;", "guildId", "Z", "memberName", "a0", "Ljava/util/concurrent/atomic/AtomicInteger;", "b0", "Ljava/util/concurrent/atomic/AtomicInteger;", "uploadCount", "Lcom/tencent/mobileqq/guild/common/upload/GuildCgiUploader;", "c0", "Lcom/tencent/mobileqq/guild/common/upload/GuildCgiUploader;", "guildCgiUploader", "Landroid/app/Dialog;", "d0", "Landroid/app/Dialog;", "loadingDialog", "Lh53/q;", "e0", "Lh53/q;", "inputViewWatcher", "<init>", "()V", "f0", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildModifyMemberNameAndAvatarFragment extends QQGuildTokenTitleBarFragment {

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: T, reason: from kotlin metadata */
    private ImageView mCameraIcon;

    /* renamed from: U, reason: from kotlin metadata */
    private QUISingleLineInputView mInputView;

    /* renamed from: V, reason: from kotlin metadata */
    private RadiusFrameLayout mGuildAvatarLayout;

    /* renamed from: W, reason: from kotlin metadata */
    private PressDarkImageView mGuildUserAvatar;

    /* renamed from: X, reason: from kotlin metadata */
    private GuildModifyMemberInfoViewModel viewModel;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildCgiUploader guildCgiUploader;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Dialog loadingDialog;

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private String guildId = "";

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    private String memberName = "";

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String uploadPath = "";

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AtomicInteger uploadCount = new AtomicInteger(0);

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final h53.q inputViewWatcher = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0007R\u0014\u0010\t\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\n\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildsetting/fragment/GuildModifyMemberNameAndAvatarFragment$a;", "", "Landroid/content/Context;", "context", "", "guildId", "userName", "", "a", "EXTRA_KEY_GUILD_MEMBER_NAME", "Ljava/lang/String;", "", "MODIFY_TYPE_NAME", "I", "MODIFY_TYPE_PIC", "TAG", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.setting.guildsetting.fragment.GuildModifyMemberNameAndAvatarFragment$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(@NotNull Context context, @NotNull String guildId, @NotNull String userName) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(userName, "userName");
            Intent intent = new Intent();
            intent.putExtra("extra_guild_id", guildId);
            intent.putExtra("extra_key_guild_member_name", userName);
            QPublicFragmentActivity.start(context, intent, GuildModifyMemberNameAndAvatarFragment.class);
        }

        Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Uh(int result, String errMsg, IGProSecurityResult security, int type) {
        if (result == 0 && ch.p(security)) {
            GuildModifyMemberInfoViewModel guildModifyMemberInfoViewModel = this.viewModel;
            String str = null;
            if (guildModifyMemberInfoViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                guildModifyMemberInfoViewModel = null;
            }
            guildModifyMemberInfoViewModel.x2();
            String str2 = "";
            if (type == 2) {
                this.uploadPath = "";
            }
            if (this.uploadCount.get() > 1) {
                this.uploadCount.getAndDecrement();
                return;
            }
            if (!TextUtils.isEmpty(this.memberName)) {
                str2 = this.memberName;
            } else {
                ev l3 = aj.l();
                if (l3 != null) {
                    str = l3.getDisplayName();
                }
                if (str != null) {
                    str2 = str;
                }
            }
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildModifyMemberNameAndAvatarFragment", 2, "[handleModifyGuildMemberBack] updateMemberName " + str2);
            }
            SimpleEventBus.getInstance().dispatchEvent(new UpdateUserInfoEvent(str2));
            Dialog dialog = this.loadingDialog;
            if (dialog != null) {
                dialog.dismiss();
            }
            ch.u1(BaseApplication.getContext(), "\u4fee\u6539\u6210\u529f");
            ei();
            return;
        }
        QLog.w("GuildModifyMemberNameAndAvatarFragment", 1, "set guildMemberName failed: result=" + result + ", errMsg=" + errMsg + ", security=" + security);
        Dialog dialog2 = this.loadingDialog;
        if (dialog2 != null) {
            dialog2.dismiss();
        }
        SecurityTipHelperKt.F(getContext(), result, errMsg, security, HardCodeUtil.qqStr(R.string.f141910hy), null, 32, null);
    }

    private final void Vh(final String path) {
        if (!TextUtils.isEmpty(path)) {
            li(path);
            GuildCgiUploader guildCgiUploader = this.guildCgiUploader;
            if (guildCgiUploader != null) {
                guildCgiUploader.f(path, com.tencent.mobileqq.guild.common.upload.c.guildUserAvatar, com.tencent.mobileqq.guild.common.upload.b.a(), new IUploadApi.b() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.fragment.h
                    @Override // com.tencent.mobileqq.guild.nt.misc.api.IUploadApi.b
                    public final void a(IUploadApi.c cVar, IUploadApi.d dVar) {
                        GuildModifyMemberNameAndAvatarFragment.Wh(GuildModifyMemberNameAndAvatarFragment.this, path, cVar, dVar);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Wh(final GuildModifyMemberNameAndAvatarFragment this$0, final String path, final IUploadApi.c cVar, final IUploadApi.d dVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(path, "$path");
        int i3 = dVar.f230931a;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.fragment.i
                        @Override // java.lang.Runnable
                        public final void run() {
                            GuildModifyMemberNameAndAvatarFragment.Xh(GuildModifyMemberNameAndAvatarFragment.this, cVar, dVar, path);
                        }
                    });
                    return;
                }
                return;
            }
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.fragment.j
                @Override // java.lang.Runnable
                public final void run() {
                    GuildModifyMemberNameAndAvatarFragment.Yh(GuildModifyMemberNameAndAvatarFragment.this, cVar, dVar, path);
                }
            });
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("GuildModifyMemberNameAndAvatarFragment", 2, "onUploadProgress: " + dVar.f230933c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Xh(GuildModifyMemberNameAndAvatarFragment this$0, IUploadApi.c task, IUploadApi.d state, String path) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(path, "$path");
        Intrinsics.checkNotNullExpressionValue(task, "task");
        Intrinsics.checkNotNullExpressionValue(state, "state");
        this$0.hi(task, state, path);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Yh(GuildModifyMemberNameAndAvatarFragment this$0, IUploadApi.c task, IUploadApi.d state, String path) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(path, "$path");
        Intrinsics.checkNotNullExpressionValue(task, "task");
        Intrinsics.checkNotNullExpressionValue(state, "state");
        this$0.ii(task, state, path);
    }

    private final void Zh() {
        if (this.guildCgiUploader == null) {
            if (TextUtils.isEmpty(this.guildId)) {
                com.tencent.mobileqq.guild.util.s.e("GuildModifyMemberNameAndAvatarFragment", "initAvatar mGuildId is null!", new IllegalArgumentException());
            }
            this.guildCgiUploader = new GuildCgiUploader(ch.g(), this.guildId);
        }
    }

    private final void ai() {
        RadiusFrameLayout radiusFrameLayout = this.mGuildAvatarLayout;
        if (radiusFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildAvatarLayout");
            radiusFrameLayout = null;
        }
        radiusFrameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.fragment.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildModifyMemberNameAndAvatarFragment.bi(GuildModifyMemberNameAndAvatarFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bi(GuildModifyMemberNameAndAvatarFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RadiusFrameLayout radiusFrameLayout = this$0.mGuildAvatarLayout;
        if (radiusFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildAvatarLayout");
            radiusFrameLayout = null;
        }
        VideoReport.reportEvent("clck", radiusFrameLayout, null);
        this$0.ri();
        VideoReport.reportEvent("clck", view, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ci(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void di(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void ei() {
        FragmentActivity activity;
        if (getActivity() != null) {
            FragmentActivity activity2 = getActivity();
            boolean z16 = false;
            if (activity2 != null && activity2.isFinishing()) {
                z16 = true;
            }
            if (!z16 && (activity = getActivity()) != null) {
                activity.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void gi(GuildModifyMemberNameAndAvatarFragment this$0, int i3, String errMsg, IGProSecurityResult security) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        Intrinsics.checkNotNullParameter(security, "security");
        Logger.f235387a.d().d("GuildModifyMemberNameAndAvatarFragment", 1, "[onSubmit] setGuildMemberName, memberName " + this$0.memberName + ", result " + i3 + ", errMsg " + errMsg + ", security " + security);
        this$0.Uh(i3, errMsg, security, 1);
    }

    private final void hi(IUploadApi.c task, IUploadApi.d state, String path) {
        int i3;
        QLog.i("GuildModifyMemberNameAndAvatarFragment", 1, "onUploadFail task: " + task + " state:" + state);
        GuildCgiUploader.b b16 = GuildCgiUploader.b.b(state);
        if (b16.f215490a == 0) {
            i3 = 2;
        } else {
            i3 = 0;
        }
        QQToastUtil.showQQToast(i3, b16.f215491b);
    }

    private final void ii(IUploadApi.c task, IUploadApi.d state, String path) {
        QLog.i("GuildModifyMemberNameAndAvatarFragment", 2, "onUploadSuccess task: " + task + " state:" + state);
        GuildCgiUploader.b c16 = GuildCgiUploader.b.c(state.f230934d);
        Uh(c16.f215490a, c16.f215491b, c16.f215492c, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ji(GuildModifyMemberNameAndAvatarFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.mInputView != null) {
            this$0.fi();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ki(GuildModifyMemberNameAndAvatarFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QUISingleLineInputView qUISingleLineInputView = this$0.mInputView;
        if (qUISingleLineInputView != null) {
            QUISingleLineInputView qUISingleLineInputView2 = null;
            if (qUISingleLineInputView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInputView");
                qUISingleLineInputView = null;
            }
            qUISingleLineInputView.a();
            QUISingleLineInputView qUISingleLineInputView3 = this$0.mInputView;
            if (qUISingleLineInputView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInputView");
            } else {
                qUISingleLineInputView2 = qUISingleLineInputView3;
            }
            qUISingleLineInputView2.p();
        }
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            Object systemService = activity.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            InputMethodManager inputMethodManager = (InputMethodManager) systemService;
            View peekDecorView = activity.getWindow().peekDecorView();
            if (peekDecorView != null && peekDecorView.getWindowToken() != null) {
                inputMethodManager.hideSoftInputFromWindow(peekDecorView.getWindowToken(), 0);
            }
        }
        this$0.onBackEvent();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void li(String path) {
        com.tencent.mobileqq.guild.performance.report.n.b(path, "6");
    }

    private final void mi() {
        GuildModifyMemberInfoViewModel guildModifyMemberInfoViewModel = this.viewModel;
        if (guildModifyMemberInfoViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildModifyMemberInfoViewModel = null;
        }
        guildModifyMemberInfoViewModel.w2(this.guildId, new GuildModifyMemberNameAndAvatarFragment$sendClearGuildAvatarRequest$1(this));
    }

    private final void ni() {
        View rightTextView = getRightTextView();
        ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
        ch.Y0(rightTextView, "em_sgrp_personalinformation_finish", clickPolicy, ExposurePolicy.REPORT_NONE);
        TextView textView = this.C;
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_ALL;
        ch.Y0(textView, "em_sgrp_personalinformation_cancel", clickPolicy, exposurePolicy);
        RadiusFrameLayout radiusFrameLayout = this.mGuildAvatarLayout;
        if (radiusFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildAvatarLayout");
            radiusFrameLayout = null;
        }
        ch.Y0(radiusFrameLayout, "em_sgrp_personalinformation_head", clickPolicy, exposurePolicy);
    }

    private final void oi() {
        Map mapOf;
        VideoReport.addToDetectionWhitelist(getQBaseActivity());
        VideoReport.setPageId(this.N, "pg_sgrp_channel_nick_profile");
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("sgrp_channel_id", this.guildId), TuplesKt.to("sgrp_user_type", ((IGuildFeedMiscApi) QRoute.api(IGuildFeedMiscApi.class)).getCurrentUserType(this.guildId)));
        VideoReport.setPageParams(this.N, new PageParams((Map<String, ?>) mapOf));
    }

    private final void pi() {
        QUISingleLineInputView qUISingleLineInputView = this.mInputView;
        QUISingleLineInputView qUISingleLineInputView2 = null;
        if (qUISingleLineInputView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInputView");
            qUISingleLineInputView = null;
        }
        qUISingleLineInputView.setTextFocusable(true);
        QUISingleLineInputView qUISingleLineInputView3 = this.mInputView;
        if (qUISingleLineInputView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInputView");
            qUISingleLineInputView3 = null;
        }
        qUISingleLineInputView3.setTextFocusableInTouchMode(true);
        QUISingleLineInputView qUISingleLineInputView4 = this.mInputView;
        if (qUISingleLineInputView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInputView");
            qUISingleLineInputView4 = null;
        }
        qUISingleLineInputView4.q();
        QUISingleLineInputView qUISingleLineInputView5 = this.mInputView;
        if (qUISingleLineInputView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInputView");
        } else {
            qUISingleLineInputView2 = qUISingleLineInputView5;
        }
        qUISingleLineInputView2.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.fragment.g
            @Override // java.lang.Runnable
            public final void run() {
                GuildModifyMemberNameAndAvatarFragment.qi(GuildModifyMemberNameAndAvatarFragment.this);
            }
        }, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void qi(GuildModifyMemberNameAndAvatarFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QUISingleLineInputView qUISingleLineInputView = this$0.mInputView;
        if (qUISingleLineInputView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInputView");
            qUISingleLineInputView = null;
        }
        qUISingleLineInputView.z();
    }

    private final void ri() {
        int i3;
        boolean z16;
        QUISingleLineInputView qUISingleLineInputView = this.mInputView;
        QUISingleLineInputView qUISingleLineInputView2 = null;
        if (qUISingleLineInputView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInputView");
            qUISingleLineInputView = null;
        }
        String valueOf = String.valueOf(qUISingleLineInputView.d());
        int length = valueOf.length() - 1;
        int i16 = 0;
        boolean z17 = false;
        while (i16 <= length) {
            if (!z17) {
                i3 = i16;
            } else {
                i3 = length;
            }
            if (Intrinsics.compare((int) valueOf.charAt(i3), 32) <= 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z17) {
                if (!z16) {
                    z17 = true;
                } else {
                    i16++;
                }
            } else if (!z16) {
                break;
            } else {
                length--;
            }
        }
        String obj = valueOf.subSequence(i16, length + 1).toString();
        GuildModifyMemberInfoViewModel guildModifyMemberInfoViewModel = this.viewModel;
        if (guildModifyMemberInfoViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildModifyMemberInfoViewModel = null;
        }
        QUISingleLineInputView qUISingleLineInputView3 = this.mInputView;
        if (qUISingleLineInputView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInputView");
        } else {
            qUISingleLineInputView2 = qUISingleLineInputView3;
        }
        Context context = qUISingleLineInputView2.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "mInputView.context");
        guildModifyMemberInfoViewModel.r2(context, this.guildId, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void si(String url) {
        PressDarkImageView pressDarkImageView = this.mGuildUserAvatar;
        PressDarkImageView pressDarkImageView2 = null;
        if (pressDarkImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildUserAvatar");
            pressDarkImageView = null;
        }
        pressDarkImageView.clearAvatarTag();
        PressDarkImageView pressDarkImageView3 = this.mGuildUserAvatar;
        if (pressDarkImageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildUserAvatar");
        } else {
            pressDarkImageView2 = pressDarkImageView3;
        }
        com.tencent.mobileqq.guild.util.v.i(url, pressDarkImageView2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ti(String uploadPath) {
        PressDarkImageView pressDarkImageView = null;
        if (!TextUtils.isEmpty(uploadPath) && new File(uploadPath).exists()) {
            PressDarkImageView pressDarkImageView2 = this.mGuildUserAvatar;
            if (pressDarkImageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGuildUserAvatar");
                pressDarkImageView2 = null;
            }
            pressDarkImageView2.clearAvatarTag();
            PressDarkImageView pressDarkImageView3 = this.mGuildUserAvatar;
            if (pressDarkImageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGuildUserAvatar");
            } else {
                pressDarkImageView = pressDarkImageView3;
            }
            com.tencent.mobileqq.guild.util.v.i(uploadPath, pressDarkImageView);
            return;
        }
        PressDarkImageView pressDarkImageView4 = this.mGuildUserAvatar;
        if (pressDarkImageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildUserAvatar");
        } else {
            pressDarkImageView = pressDarkImageView4;
        }
        pressDarkImageView.setAvatarTinyId(this.guildId, ch.f());
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x011b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void fi() {
        CharSequence trim;
        String str;
        boolean z16;
        HashMap hashMapOf;
        boolean z17;
        Intent intent;
        Dialog dialog = this.loadingDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
        this.uploadCount.set(0);
        QUISingleLineInputView qUISingleLineInputView = this.mInputView;
        GuildModifyMemberInfoViewModel guildModifyMemberInfoViewModel = null;
        if (qUISingleLineInputView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInputView");
            qUISingleLineInputView = null;
        }
        trim = StringsKt__StringsKt.trim((CharSequence) String.valueOf(qUISingleLineInputView.d()));
        this.memberName = trim.toString();
        FragmentActivity activity = getActivity();
        if (activity == null || (intent = activity.getIntent()) == null || (str = intent.getStringExtra("extra_key_guild_member_name")) == null) {
            str = "";
        }
        boolean z18 = !Intrinsics.areEqual(str, this.memberName);
        boolean z19 = !TextUtils.isEmpty(this.uploadPath);
        if (!z19) {
            GuildModifyMemberInfoViewModel guildModifyMemberInfoViewModel2 = this.viewModel;
            if (guildModifyMemberInfoViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                guildModifyMemberInfoViewModel = guildModifyMemberInfoViewModel2;
            }
            GuildModifyMemberInfoViewModel.ModifyAvatarState value = guildModifyMemberInfoViewModel.k2().getValue();
            if (value != null && value.getClearAvatar()) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                z16 = true;
                View rightTextView = getRightTextView();
                hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("sgrp_nick", this.memberName));
                VideoReport.reportEvent("clck", rightTextView, hashMapOf);
                Logger.f235387a.d().d("GuildModifyMemberNameAndAvatarFragment", 1, "[onSubmit] needModifyNickName " + z18 + ", needModifyAvatar " + z19 + ", needClearAvatar " + z16);
                if (z18) {
                    this.uploadCount.getAndIncrement();
                }
                if (!z19 || z16) {
                    this.uploadCount.getAndIncrement();
                }
                if (this.uploadCount.get() <= 0) {
                    Dialog showOnlyLoadingImageDialog = LoadingUtil.showOnlyLoadingImageDialog(getContext(), 1, false);
                    this.loadingDialog = showOnlyLoadingImageDialog;
                    if (showOnlyLoadingImageDialog != null) {
                        showOnlyLoadingImageDialog.show();
                    }
                    if (z18) {
                        ((IGPSService) ch.R0(IGPSService.class)).setGuildMemberName(this.guildId, this.memberName, ch.l().getCurrentNickname(), new dv() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.fragment.f
                            @Override // wh2.dv
                            public final void a(int i3, String str2, IGProSecurityResult iGProSecurityResult) {
                                GuildModifyMemberNameAndAvatarFragment.gi(GuildModifyMemberNameAndAvatarFragment.this, i3, str2, iGProSecurityResult);
                            }
                        });
                    }
                    if (z16) {
                        mi();
                        return;
                    } else {
                        if (z19) {
                            Zh();
                            Vh(this.uploadPath);
                            return;
                        }
                        return;
                    }
                }
                ei();
                return;
            }
        }
        z16 = false;
        View rightTextView2 = getRightTextView();
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("sgrp_nick", this.memberName));
        VideoReport.reportEvent("clck", rightTextView2, hashMapOf);
        Logger.f235387a.d().d("GuildModifyMemberNameAndAvatarFragment", 1, "[onSubmit] needModifyNickName " + z18 + ", needModifyAvatar " + z19 + ", needClearAvatar " + z16);
        if (z18) {
        }
        if (!z19) {
        }
        this.uploadCount.getAndIncrement();
        if (this.uploadCount.get() <= 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f0b;
    }

    public final void initData() {
        String str;
        String str2;
        Intent intent;
        Intent intent2;
        FragmentActivity activity = getActivity();
        GuildModifyMemberInfoViewModel guildModifyMemberInfoViewModel = null;
        if (activity != null && (intent2 = activity.getIntent()) != null) {
            str = intent2.getStringExtra("extra_guild_id");
        } else {
            str = null;
        }
        String str3 = "";
        if (str == null) {
            str = "";
        }
        this.guildId = str;
        FragmentActivity activity2 = getActivity();
        if (activity2 != null && (intent = activity2.getIntent()) != null) {
            str2 = intent.getStringExtra("extra_key_guild_member_name");
        } else {
            str2 = null;
        }
        if (str2 != null) {
            str3 = str2;
        }
        this.memberName = str3;
        GuildModifyMemberInfoViewModel.Companion companion = GuildModifyMemberInfoViewModel.INSTANCE;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        this.viewModel = companion.a(requireActivity, this.guildId);
        Logger.f235387a.d().d("GuildModifyMemberNameAndAvatarFragment", 1, "[initData] memberName " + this.memberName);
        QUISingleLineInputView qUISingleLineInputView = this.mInputView;
        if (qUISingleLineInputView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInputView");
            qUISingleLineInputView = null;
        }
        qUISingleLineInputView.setHint(ch.l().getCurrentNickname());
        QUISingleLineInputView qUISingleLineInputView2 = this.mInputView;
        if (qUISingleLineInputView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInputView");
            qUISingleLineInputView2 = null;
        }
        qUISingleLineInputView2.setShowPromptText(false);
        if (!TextUtils.isEmpty(this.memberName)) {
            QUISingleLineInputView qUISingleLineInputView3 = this.mInputView;
            if (qUISingleLineInputView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInputView");
                qUISingleLineInputView3 = null;
            }
            qUISingleLineInputView3.setContentText(this.memberName);
            QUISingleLineInputView qUISingleLineInputView4 = this.mInputView;
            if (qUISingleLineInputView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInputView");
                qUISingleLineInputView4 = null;
            }
            qUISingleLineInputView4.setMaxWordCount(12);
            QUISingleLineInputView qUISingleLineInputView5 = this.mInputView;
            if (qUISingleLineInputView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInputView");
                qUISingleLineInputView5 = null;
            }
            qUISingleLineInputView5.setTextSelection(this.memberName.length());
        } else {
            GuildModifyMemberInfoViewModel guildModifyMemberInfoViewModel2 = this.viewModel;
            if (guildModifyMemberInfoViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                guildModifyMemberInfoViewModel2 = null;
            }
            LiveData<String> m26 = guildModifyMemberInfoViewModel2.m2();
            LifecycleOwner lifecycleOwner = getLifecycleOwner();
            final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.fragment.GuildModifyMemberNameAndAvatarFragment$initData$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str4) {
                    invoke2(str4);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String it) {
                    Logger.f235387a.d().d("GuildModifyMemberNameAndAvatarFragment", 1, "[initData] userName.observe " + it);
                    QUISingleLineInputView qUISingleLineInputView6 = GuildModifyMemberNameAndAvatarFragment.this.mInputView;
                    QUISingleLineInputView qUISingleLineInputView7 = null;
                    if (qUISingleLineInputView6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mInputView");
                        qUISingleLineInputView6 = null;
                    }
                    qUISingleLineInputView6.h().setEnabled(true);
                    QUISingleLineInputView qUISingleLineInputView8 = GuildModifyMemberNameAndAvatarFragment.this.mInputView;
                    if (qUISingleLineInputView8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mInputView");
                        qUISingleLineInputView8 = null;
                    }
                    qUISingleLineInputView8.setContentText(it);
                    QUISingleLineInputView qUISingleLineInputView9 = GuildModifyMemberNameAndAvatarFragment.this.mInputView;
                    if (qUISingleLineInputView9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mInputView");
                        qUISingleLineInputView9 = null;
                    }
                    qUISingleLineInputView9.setMaxWordCount(12);
                    QUISingleLineInputView qUISingleLineInputView10 = GuildModifyMemberNameAndAvatarFragment.this.mInputView;
                    if (qUISingleLineInputView10 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mInputView");
                    } else {
                        qUISingleLineInputView7 = qUISingleLineInputView10;
                    }
                    qUISingleLineInputView7.setTextSelection(it.length());
                    GuildModifyMemberNameAndAvatarFragment guildModifyMemberNameAndAvatarFragment = GuildModifyMemberNameAndAvatarFragment.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    guildModifyMemberNameAndAvatarFragment.memberName = it;
                }
            };
            m26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.fragment.c
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    GuildModifyMemberNameAndAvatarFragment.ci(Function1.this, obj);
                }
            });
            GuildModifyMemberInfoViewModel guildModifyMemberInfoViewModel3 = this.viewModel;
            if (guildModifyMemberInfoViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                guildModifyMemberInfoViewModel3 = null;
            }
            guildModifyMemberInfoViewModel3.y2();
            QUISingleLineInputView qUISingleLineInputView6 = this.mInputView;
            if (qUISingleLineInputView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInputView");
                qUISingleLineInputView6 = null;
            }
            qUISingleLineInputView6.h().setEnabled(false);
        }
        QUISingleLineInputView qUISingleLineInputView7 = this.mInputView;
        if (qUISingleLineInputView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInputView");
            qUISingleLineInputView7 = null;
        }
        qUISingleLineInputView7.setStyle(1);
        QUISingleLineInputView qUISingleLineInputView8 = this.mInputView;
        if (qUISingleLineInputView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInputView");
            qUISingleLineInputView8 = null;
        }
        qUISingleLineInputView8.setInputViewWatcher(this.inputViewWatcher);
        ti(this.uploadPath);
        GuildModifyMemberInfoViewModel guildModifyMemberInfoViewModel4 = this.viewModel;
        if (guildModifyMemberInfoViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            guildModifyMemberInfoViewModel = guildModifyMemberInfoViewModel4;
        }
        LiveData<GuildModifyMemberInfoViewModel.ModifyAvatarState> k26 = guildModifyMemberInfoViewModel.k2();
        FragmentActivity requireActivity2 = requireActivity();
        final Function1<GuildModifyMemberInfoViewModel.ModifyAvatarState, Unit> function12 = new Function1<GuildModifyMemberInfoViewModel.ModifyAvatarState, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.fragment.GuildModifyMemberNameAndAvatarFragment$initData$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GuildModifyMemberInfoViewModel.ModifyAvatarState modifyAvatarState) {
                invoke2(modifyAvatarState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(GuildModifyMemberInfoViewModel.ModifyAvatarState modifyAvatarState) {
                if (modifyAvatarState.getClearAvatar()) {
                    GuildModifyMemberNameAndAvatarFragment.this.uploadPath = "";
                    GuildModifyMemberNameAndAvatarFragment.this.si(modifyAvatarState.getLocalPath());
                } else {
                    GuildModifyMemberNameAndAvatarFragment.this.uploadPath = modifyAvatarState.getLocalPath();
                    GuildModifyMemberNameAndAvatarFragment.this.ti(modifyAvatarState.getLocalPath());
                }
                GuildModifyMemberNameAndAvatarFragment.this.setRightButtonEnable(true);
            }
        };
        k26.observe(requireActivity2, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.fragment.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildModifyMemberNameAndAvatarFragment.di(Function1.this, obj);
            }
        });
        pi();
        setRightButtonEnable(false);
    }

    public final void initView() {
        int i3;
        View findViewById = this.P.findViewById(R.id.wju);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mContentView.findViewByI\u2026uild_input_view_nickname)");
        this.mInputView = (QUISingleLineInputView) findViewById;
        View findViewById2 = this.P.findViewById(R.id.wfw);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mContentView.findViewById(R.id.guild_fl_avatar)");
        this.mGuildAvatarLayout = (RadiusFrameLayout) findViewById2;
        View findViewById3 = this.P.findViewById(R.id.x4a);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mContentView.findViewById(R.id.guild_user_avatar)");
        this.mGuildUserAvatar = (PressDarkImageView) findViewById3;
        View findViewById4 = this.P.findViewById(R.id.aok);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "mContentView.findViewById(R.id.camera_icon)");
        this.mCameraIcon = (ImageView) findViewById4;
        if (QQTheme.isVasTheme()) {
            i3 = R.color.qui_common_text_primary;
        } else {
            i3 = R.color.qui_common_icon_primary;
        }
        ImageView imageView = this.mCameraIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCameraIcon");
            imageView = null;
        }
        GuildUIUtils.d(imageView, R.drawable.guild_camera16, Integer.valueOf(i3));
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        FragmentActivity activity;
        super.onActivityResult(requestCode, resultCode, data);
        if (this.viewModel != null && (activity = getActivity()) != null) {
            GuildModifyMemberInfoViewModel guildModifyMemberInfoViewModel = this.viewModel;
            if (guildModifyMemberInfoViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                guildModifyMemberInfoViewModel = null;
            }
            guildModifyMemberInfoViewModel.n2(activity, requestCode, resultCode, data);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        rh();
        setTitle(getResources().getString(R.string.f156301ju));
        setRightButton(R.string.f143340lt, new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.fragment.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                GuildModifyMemberNameAndAvatarFragment.ji(GuildModifyMemberNameAndAvatarFragment.this, view2);
            }
        });
        this.C.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.fragment.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                GuildModifyMemberNameAndAvatarFragment.ki(GuildModifyMemberNameAndAvatarFragment.this, view2);
            }
        });
        initView();
        initData();
        ai();
        oi();
        ni();
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void rh() {
        this.J.a();
        this.J.setBackgroundResource(R.drawable.lvj);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J*\u0010\u000f\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J*\u0010\u0011\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0012H\u0016\u00a8\u0006\u0014"}, d2 = {"com/tencent/mobileqq/guild/setting/guildsetting/fragment/GuildModifyMemberNameAndAvatarFragment$b", "Lh53/q;", "", "hasFocus", "", "f8", "", "title", "A4", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements h53.q {
        b() {
        }

        @Override // h53.k
        public void afterTextChanged(@Nullable Editable s16) {
            boolean z16;
            CharSequence trim;
            QUISingleLineInputView qUISingleLineInputView = GuildModifyMemberNameAndAvatarFragment.this.mInputView;
            QUISingleLineInputView qUISingleLineInputView2 = null;
            if (qUISingleLineInputView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInputView");
                qUISingleLineInputView = null;
            }
            String valueOf = String.valueOf(qUISingleLineInputView.d());
            if (!TextUtils.isEmpty(valueOf)) {
                trim = StringsKt__StringsKt.trim((CharSequence) valueOf);
                if (TextUtils.isEmpty(trim.toString())) {
                    QUISingleLineInputView qUISingleLineInputView3 = GuildModifyMemberNameAndAvatarFragment.this.mInputView;
                    if (qUISingleLineInputView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mInputView");
                        qUISingleLineInputView3 = null;
                    }
                    qUISingleLineInputView3.setContentText("");
                }
            }
            String replace = new Regex("[\\s]+").replace(valueOf, " ");
            if (!Intrinsics.areEqual(replace, valueOf)) {
                QUISingleLineInputView qUISingleLineInputView4 = GuildModifyMemberNameAndAvatarFragment.this.mInputView;
                if (qUISingleLineInputView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mInputView");
                    qUISingleLineInputView4 = null;
                }
                qUISingleLineInputView4.setContentText(replace);
                QUISingleLineInputView qUISingleLineInputView5 = GuildModifyMemberNameAndAvatarFragment.this.mInputView;
                if (qUISingleLineInputView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mInputView");
                    qUISingleLineInputView5 = null;
                }
                QUISingleLineInputView qUISingleLineInputView6 = GuildModifyMemberNameAndAvatarFragment.this.mInputView;
                if (qUISingleLineInputView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mInputView");
                    qUISingleLineInputView6 = null;
                }
                qUISingleLineInputView5.setTextSelection(String.valueOf(qUISingleLineInputView6.d()).length());
            }
            QUISingleLineInputView qUISingleLineInputView7 = GuildModifyMemberNameAndAvatarFragment.this.mInputView;
            if (qUISingleLineInputView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInputView");
            } else {
                qUISingleLineInputView2 = qUISingleLineInputView7;
            }
            if (valueOf.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            qUISingleLineInputView2.setShowPromptText(z16);
            GuildModifyMemberNameAndAvatarFragment.this.setRightButtonEnable(true);
        }

        @Override // h53.q
        public void A4(@Nullable String title) {
        }

        @Override // h53.k
        public void f8(boolean hasFocus) {
        }

        @Override // h53.k
        public void beforeTextChanged(@Nullable CharSequence s16, int start, int count, int after) {
        }

        @Override // h53.k
        public void onTextChanged(@Nullable CharSequence s16, int start, int before, int count) {
        }
    }
}
