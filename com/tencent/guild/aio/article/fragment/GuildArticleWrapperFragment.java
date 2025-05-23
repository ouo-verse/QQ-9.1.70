package com.tencent.guild.aio.article.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.guild.aio.article.data.GuildArticleMsgListCenter;
import com.tencent.guild.aio.article.data.f;
import com.tencent.guild.aio.article.launcher.GuildBaseFragment;
import com.tencent.guild.aio.article.msglist.GuildArticleMsgListEvent;
import com.tencent.guild.aio.article.widget.GuildSwipeBackLayout;
import com.tencent.guild.aio.util.ui.UIUtil;
import com.tencent.guild.api.activity.IAIOSingleActivityApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.at;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.widget.immersive.ImmersiveUtils;
import in0.a;
import in0.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import us.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 (2\u00020\u0001:\u0001)B\u0007\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\u0012\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J&\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u000e\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012J\b\u0010\u0015\u001a\u00020\u0012H\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010%\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010\"\u00a8\u0006*"}, d2 = {"Lcom/tencent/guild/aio/article/fragment/GuildArticleWrapperFragment;", "Lcom/tencent/guild/aio/article/launcher/GuildBaseFragment;", "", "sh", "setStatusBar", "Lcom/tencent/guild/aio/article/data/GuildArticleMsgListCenter;", "rh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "canScrollUp", "th", "onBackEvent", "Lus/a;", BdhLogUtil.LogTag.Tag_Conn, "Lus/a;", "mChatFragmentProvider", "D", "Lcom/tencent/guild/aio/article/data/GuildArticleMsgListCenter;", "mMsgListCenter", "E", "Z", "mCanScrollUp", "", UserInfo.SEX_FEMALE, "Ljava/lang/String;", "mGuildId", "G", "mChannelId", "<init>", "()V", "H", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildArticleWrapperFragment extends GuildBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private a mChatFragmentProvider;

    /* renamed from: D, reason: from kotlin metadata */
    private GuildArticleMsgListCenter mMsgListCenter;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean mCanScrollUp;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private String mGuildId;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private String mChannelId;

    private final void setStatusBar() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            UIUtil.f112434a.B(activity, activity.getResources().getColor(R.color.ajr));
            ImmersiveUtils.setStatusTextColor(!QQTheme.isNowThemeIsNight(), activity.getWindow());
            if (Build.VERSION.SDK_INT >= 26) {
                View decorView = activity.getWindow().getDecorView();
                decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 16);
            }
        }
    }

    private final void sh() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mGuildId = arguments.getString("guild_article_guild_id");
            this.mChannelId = arguments.getString("guild_article_channel_id");
            GuildArticleMsgListCenter guildArticleMsgListCenter = new GuildArticleMsgListCenter(new f(new Contact(4, this.mChannelId, this.mGuildId), arguments.getLong("guild_article_main_msg_seq", 0L), arguments.getLong("guild_article_rsp_msg_seq", 0L), arguments.getInt("LAUNCHER_FROM_KEY", 0)));
            this.mMsgListCenter = guildArticleMsgListCenter;
            guildArticleMsgListCenter.D();
        }
    }

    @Override // com.tencent.guild.aio.article.launcher.GuildBaseFragment
    public boolean onBackEvent() {
        a aVar = this.mChatFragmentProvider;
        if (aVar != null) {
            return aVar.onBackPressed();
        }
        return super.onBackEvent();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!at.c()) {
            QLog.e("GuildArticleWrapperFragment", 1, "onCreate isWrapperSessionReady false");
        } else {
            sh();
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intent intent;
        int i3;
        a aVar;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = LayoutInflater.from(BaseApplication.context).inflate(R.layout.eg5, container, false);
        if (!at.c()) {
            QLog.e("GuildArticleWrapperFragment", 1, "onCreateView isWrapperSessionReady false");
        } else {
            String clsName = b.class.getName();
            a.Companion companion = in0.a.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(clsName, "clsName");
            FragmentActivity activity = getActivity();
            if (activity != null) {
                intent = activity.getIntent();
            } else {
                intent = null;
            }
            Bundle arguments = getArguments();
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            this.mChatFragmentProvider = companion.a(clsName, intent, arguments, childFragmentManager, R.id.vyt);
            Resources resources = BaseApplication.context.getResources();
            if (UIUtil.f112434a.A()) {
                i3 = R.drawable.skin_chat_background;
            } else {
                i3 = R.drawable.qui_common_bg_chat_bg;
            }
            Drawable drawable = ResourcesCompat.getDrawable(resources, i3, null);
            if (drawable != null && (aVar = this.mChatFragmentProvider) != null) {
                aVar.k(drawable);
            }
            setStatusBar();
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull final View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        final GuildSwipeBackLayout guildSwipeBackLayout = (GuildSwipeBackLayout) view.getRootView().findViewById(R.id.vyt);
        guildSwipeBackLayout.setBeforeInteceptActionMove(new Function2<Float, Float, Unit>() { // from class: com.tencent.guild.aio.article.fragment.GuildArticleWrapperFragment$onViewCreated$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Float f16, Float f17) {
                invoke(f16.floatValue(), f17.floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(float f16, float f17) {
                us.a aVar;
                boolean z16;
                if (f17 > 0.0f) {
                    aVar = GuildArticleWrapperFragment.this.mChatFragmentProvider;
                    if (aVar != null) {
                        aVar.a(new GuildArticleMsgListEvent.UpdateCanScrollUpState());
                    }
                    GuildSwipeBackLayout guildSwipeBackLayout2 = guildSwipeBackLayout;
                    z16 = GuildArticleWrapperFragment.this.mCanScrollUp;
                    guildSwipeBackLayout2.setEnableVerticalScroll(!z16);
                    return;
                }
                guildSwipeBackLayout.setEnableVerticalScroll(false);
            }
        });
        guildSwipeBackLayout.setOnScrollFinish(new Function1<Boolean, Unit>() { // from class: com.tencent.guild.aio.article.fragment.GuildArticleWrapperFragment$onViewCreated$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                if (!z16) {
                    if (GuildArticleWrapperFragment.this.getActivity() != null) {
                        IAIOSingleActivityApi iAIOSingleActivityApi = (IAIOSingleActivityApi) QRoute.api(IAIOSingleActivityApi.class);
                        FragmentActivity requireActivity = GuildArticleWrapperFragment.this.requireActivity();
                        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                        if (iAIOSingleActivityApi.isGuildAIOSingleTaskActivity(requireActivity)) {
                            FragmentActivity activity = GuildArticleWrapperFragment.this.getActivity();
                            if (activity != null) {
                                activity.finish();
                                return;
                            }
                            return;
                        }
                    }
                    FragmentActivity activity2 = GuildArticleWrapperFragment.this.getActivity();
                    if (activity2 != null) {
                        activity2.onBackPressed();
                        return;
                    }
                    return;
                }
                view.setAlpha(1.0f);
            }
        });
        guildSwipeBackLayout.setOnPosChange(new Function1<Float, Unit>() { // from class: com.tencent.guild.aio.article.fragment.GuildArticleWrapperFragment$onViewCreated$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Float f16) {
                invoke(f16.floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(float f16) {
                view.setAlpha(1.0f - f16);
            }
        });
    }

    @NotNull
    public final GuildArticleMsgListCenter rh() {
        GuildArticleMsgListCenter guildArticleMsgListCenter = this.mMsgListCenter;
        if (guildArticleMsgListCenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMsgListCenter");
            return null;
        }
        return guildArticleMsgListCenter;
    }

    public final void th(boolean canScrollUp) {
        this.mCanScrollUp = canScrollUp;
    }
}
