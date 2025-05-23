package com.tencent.mobileqq.guild.home.fragments.ban;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.guild.aio.util.ex.ViewExtKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.home.views.ban.GuildHomeBanLayout;
import com.tencent.mobileqq.guild.homev2.views.GuildNavigateTitleContainer;
import com.tencent.mobileqq.guild.jump.GuildJumpUtil;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 &2\u00020\u0001:\u0001'B\u0007\u00a2\u0006\u0004\b$\u0010%J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0014J&\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0014\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\"\u0010#\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/guild/home/fragments/ban/GuildVisitorExceptionFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "jumpParams", "", "sh", "", "getContentLayoutId", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "initWindowStyleAndAnimation", "Lcom/tencent/mobileqq/guild/homev2/views/GuildNavigateTitleContainer;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/homev2/views/GuildNavigateTitleContainer;", "guildNavigationBar", "Lcom/tencent/mobileqq/guild/home/views/ban/GuildHomeBanLayout;", "D", "Lcom/tencent/mobileqq/guild/home/views/ban/GuildHomeBanLayout;", "guildBanLayout", "E", "I", "getBanType", "()I", "setBanType", "(I)V", "banType", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildVisitorExceptionFragment extends QPublicBaseFragment {

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private GuildNavigateTitleContainer guildNavigationBar;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private GuildHomeBanLayout guildBanLayout;

    /* renamed from: E, reason: from kotlin metadata */
    private int banType;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ.\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH\u0007R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u000eR\u0014\u0010\u0019\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u000eR\u0014\u0010\u001a\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u000eR\u0014\u0010\u001b\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u000e\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/home/fragments/ban/GuildVisitorExceptionFragment$a;", "", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "params", "", "banType", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "", "a", "", "KEY_BAN_GUILD_ID", "Ljava/lang/String;", "KEY_BAN_MAIN_SOURCE", "KEY_BAN_SUB_SOURCE", "KEY_BAN_TYPE", "KEY_BAN_TYPE_CHANNEL_DISAPPEAR", "I", "KEY_BAN_TYPE_GUILD_BANNED", "KEY_BAN_TYPE_GUILD_DISAPPEAR", "KEY_BAN_TYPE_USER_BANNED", "KEY_BAN_TYPE_USER_NO_AUTHORITY", "KEY_GUILD_INFO", "KEY_OPEN_PARAMS_PARCELABLE", "TAG", "TITLE", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.home.fragments.ban.GuildVisitorExceptionFragment$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void b(Companion companion, Context context, JumpGuildParam jumpGuildParam, int i3, IGProGuildInfo iGProGuildInfo, int i16, Object obj) {
            if ((i16 & 4) != 0) {
                i3 = 0;
            }
            if ((i16 & 8) != 0) {
                iGProGuildInfo = null;
            }
            companion.a(context, jumpGuildParam, i3, iGProGuildInfo);
        }

        @JvmStatic
        public final void a(@NotNull Context context, @NotNull JumpGuildParam params, int banType, @Nullable IGProGuildInfo guildInfo) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(params, "params");
            Intent intent = new Intent();
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            intent.putExtra("key_open_params", (Parcelable) params);
            intent.putExtra("key_ban_type", banType);
            if (guildInfo != null) {
                intent.putExtra("KEY_GUILD_INFO", guildInfo);
            }
            GuildSplitViewUtils.p(GuildSplitViewUtils.f235370a, context, intent, GuildVisitorExceptionFragment.class, null, 8, null);
        }

        Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sh(IGProGuildInfo guildInfo, JumpGuildParam jumpParams) {
        int i3;
        if (guildInfo != null && (i3 = this.banType) != 0 && i3 != 1 && i3 != 4) {
            jumpParams.setChannelId("");
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            GuildJumpUtil.n(requireContext, jumpParams);
            return;
        }
        QLog.w("GuildVisitorBanFragment", 1, " guild error ,guildId = [" + guildInfo + "]");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void th(String str, GuildVisitorExceptionFragment this$0, Ref.ObjectRef guildInfo, JumpGuildParam jumpGuildParam, String mainSource, String subSource, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(guildInfo, "$guildInfo");
        Intrinsics.checkNotNullParameter(mainSource, "$mainSource");
        Intrinsics.checkNotNullParameter(subSource, "$subSource");
        QLog.d("GuildVisitorBanFragment", 1, " GoHomeBtnClick start guild " + str);
        IGProGuildInfo iGProGuildInfo = (IGProGuildInfo) guildInfo.element;
        if (jumpGuildParam == null) {
            jumpGuildParam = new JumpGuildParam(str, "", "", mainSource, subSource);
        }
        this$0.sh(iGProGuildInfo, jumpGuildParam);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsets uh(GuildHomeBanLayout this_apply, View view, WindowInsets windowInsets) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        ViewExtKt.f(this_apply, 0);
        return windowInsets;
    }

    @JvmStatic
    public static final void vh(@NotNull Context context, @NotNull JumpGuildParam jumpGuildParam, int i3, @Nullable IGProGuildInfo iGProGuildInfo) {
        INSTANCE.a(context, jumpGuildParam, i3, iGProGuildInfo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.esb;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(@Nullable Activity activity) {
        super.initWindowStyleAndAnimation(activity);
        if (activity != null) {
            activity.overridePendingTransition(R.anim.l_, R.anim.l_);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bd  */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10, types: [com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo] */
    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        GuildNavigateTitleContainer guildNavigateTitleContainer;
        GuildHomeBanLayout guildHomeBanLayout;
        JumpGuildParam jumpGuildParam;
        String str;
        String string;
        String str2;
        String str3;
        String str4;
        String str5;
        Bundle arguments;
        int i3;
        Bundle arguments2;
        Serializable serializable;
        T t16;
        GuildNavigateTitleContainer guildNavigateTitleContainer2;
        final GuildHomeBanLayout guildHomeBanLayout2;
        JumpGuildParam.JoinInfoParam joinInfoParam;
        JumpGuildParam.JoinInfoParam joinInfoParam2;
        Bundle bundle;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View onCreateView = super.onCreateView(inflater, container, savedInstanceState);
        T t17 = 0;
        if (onCreateView != null) {
            guildNavigateTitleContainer = (GuildNavigateTitleContainer) onCreateView.findViewById(R.id.ws8);
        } else {
            guildNavigateTitleContainer = null;
        }
        this.guildNavigationBar = guildNavigateTitleContainer;
        if (onCreateView != null) {
            guildHomeBanLayout = (GuildHomeBanLayout) onCreateView.findViewById(R.id.f165532wi2);
        } else {
            guildHomeBanLayout = null;
        }
        this.guildBanLayout = guildHomeBanLayout;
        Bundle arguments3 = getArguments();
        if (arguments3 != null) {
            jumpGuildParam = (JumpGuildParam) arguments3.getParcelable("key_open_params");
        } else {
            jumpGuildParam = null;
        }
        if (jumpGuildParam != null && (bundle = jumpGuildParam.extras) != null) {
            bundle.remove("jumpGuildFromLoadingPage");
        }
        if (jumpGuildParam == null || (string = jumpGuildParam.guildId) == null) {
            Bundle arguments4 = getArguments();
            if (arguments4 != null) {
                string = arguments4.getString("key_ban_guild_id");
            } else {
                str = null;
                if (jumpGuildParam == null && (joinInfoParam2 = jumpGuildParam.getJoinInfoParam()) != null) {
                    str2 = joinInfoParam2.getMainSource();
                } else {
                    str2 = null;
                }
                if (str2 == null) {
                    Bundle arguments5 = getArguments();
                    if (arguments5 != null) {
                        str2 = arguments5.getString("key_ban_main_source");
                    } else {
                        str2 = null;
                    }
                    if (str2 == null) {
                        str3 = "";
                        if (jumpGuildParam == null && (joinInfoParam = jumpGuildParam.getJoinInfoParam()) != null) {
                            str4 = joinInfoParam.getSubSource();
                        } else {
                            str4 = null;
                        }
                        if (str4 == null) {
                            Bundle arguments6 = getArguments();
                            if (arguments6 != null) {
                                str4 = arguments6.getString("key_ban_sub_source");
                            } else {
                                str4 = null;
                            }
                            if (str4 == null) {
                                str5 = "";
                                arguments = getArguments();
                                if (arguments == null) {
                                    i3 = arguments.getInt("key_ban_type", 0);
                                } else {
                                    i3 = 0;
                                }
                                this.banType = i3;
                                final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                                arguments2 = getArguments();
                                if (arguments2 == null) {
                                    serializable = arguments2.getSerializable("KEY_GUILD_INFO");
                                } else {
                                    serializable = null;
                                }
                                if (!(serializable instanceof IGProGuildInfo)) {
                                    t16 = (IGProGuildInfo) serializable;
                                } else {
                                    t16 = 0;
                                }
                                objectRef.element = t16;
                                if (t16 == 0) {
                                    boolean z16 = true;
                                    QLog.i("GuildVisitorBanFragment", 1, " guildInfo is nul, guild is" + str);
                                    if (str != null && str.length() != 0) {
                                        z16 = false;
                                    }
                                    if (!z16) {
                                        t17 = ch.L(str);
                                    }
                                    objectRef.element = t17;
                                }
                                guildNavigateTitleContainer2 = this.guildNavigationBar;
                                if (guildNavigateTitleContainer2 != null) {
                                    guildNavigateTitleContainer2.M0((IGProGuildInfo) objectRef.element);
                                    guildNavigateTitleContainer2.E0(new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.home.fragments.ban.GuildVisitorExceptionFragment$onCreateView$1$1
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
                                            GuildSplitViewUtils.u(GuildSplitViewUtils.f235370a, GuildVisitorExceptionFragment.this.getActivity(), false, 2, null);
                                        }
                                    });
                                    final String str6 = str;
                                    final JumpGuildParam jumpGuildParam2 = jumpGuildParam;
                                    final String str7 = str3;
                                    final String str8 = str5;
                                    guildNavigateTitleContainer2.F0(new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.home.fragments.ban.GuildVisitorExceptionFragment$onCreateView$1$2
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                            QLog.d("GuildVisitorBanFragment", 1, " guildNavigationBar start guild " + str6);
                                            GuildVisitorExceptionFragment guildVisitorExceptionFragment = this;
                                            IGProGuildInfo iGProGuildInfo = objectRef.element;
                                            JumpGuildParam jumpGuildParam3 = jumpGuildParam2;
                                            if (jumpGuildParam3 == null) {
                                                jumpGuildParam3 = new JumpGuildParam(str6, "", "", str7, str8);
                                            }
                                            guildVisitorExceptionFragment.sh(iGProGuildInfo, jumpGuildParam3);
                                        }
                                    });
                                }
                                guildHomeBanLayout2 = this.guildBanLayout;
                                if (guildHomeBanLayout2 != null) {
                                    Context requireContext = requireContext();
                                    Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                                    guildHomeBanLayout2.n(requireContext, (IGProGuildInfo) objectRef.element, false, this.banType);
                                    final String str9 = str;
                                    final JumpGuildParam jumpGuildParam3 = jumpGuildParam;
                                    final String str10 = str3;
                                    final String str11 = str5;
                                    guildHomeBanLayout2.setOnGoHomeBtnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.home.fragments.ban.a
                                        @Override // android.view.View.OnClickListener
                                        public final void onClick(View view) {
                                            GuildVisitorExceptionFragment.th(str9, this, objectRef, jumpGuildParam3, str10, str11, view);
                                        }
                                    });
                                    guildHomeBanLayout2.setSource(str3, str5);
                                    guildHomeBanLayout2.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.tencent.mobileqq.guild.home.fragments.ban.b
                                        @Override // android.view.View.OnApplyWindowInsetsListener
                                        public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                                            WindowInsets uh5;
                                            uh5 = GuildVisitorExceptionFragment.uh(GuildHomeBanLayout.this, view, windowInsets);
                                            return uh5;
                                        }
                                    });
                                }
                                AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
                                return onCreateView;
                            }
                        }
                        str5 = str4;
                        arguments = getArguments();
                        if (arguments == null) {
                        }
                        this.banType = i3;
                        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                        arguments2 = getArguments();
                        if (arguments2 == null) {
                        }
                        if (!(serializable instanceof IGProGuildInfo)) {
                        }
                        objectRef2.element = t16;
                        if (t16 == 0) {
                        }
                        guildNavigateTitleContainer2 = this.guildNavigationBar;
                        if (guildNavigateTitleContainer2 != null) {
                        }
                        guildHomeBanLayout2 = this.guildBanLayout;
                        if (guildHomeBanLayout2 != null) {
                        }
                        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
                        return onCreateView;
                    }
                }
                str3 = str2;
                if (jumpGuildParam == null) {
                }
                str4 = null;
                if (str4 == null) {
                }
                str5 = str4;
                arguments = getArguments();
                if (arguments == null) {
                }
                this.banType = i3;
                final Ref.ObjectRef objectRef22 = new Ref.ObjectRef();
                arguments2 = getArguments();
                if (arguments2 == null) {
                }
                if (!(serializable instanceof IGProGuildInfo)) {
                }
                objectRef22.element = t16;
                if (t16 == 0) {
                }
                guildNavigateTitleContainer2 = this.guildNavigationBar;
                if (guildNavigateTitleContainer2 != null) {
                }
                guildHomeBanLayout2 = this.guildBanLayout;
                if (guildHomeBanLayout2 != null) {
                }
                AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
                return onCreateView;
            }
        }
        str = string;
        if (jumpGuildParam == null) {
        }
        str2 = null;
        if (str2 == null) {
        }
        str3 = str2;
        if (jumpGuildParam == null) {
        }
        str4 = null;
        if (str4 == null) {
        }
        str5 = str4;
        arguments = getArguments();
        if (arguments == null) {
        }
        this.banType = i3;
        final Ref.ObjectRef objectRef222 = new Ref.ObjectRef();
        arguments2 = getArguments();
        if (arguments2 == null) {
        }
        if (!(serializable instanceof IGProGuildInfo)) {
        }
        objectRef222.element = t16;
        if (t16 == 0) {
        }
        guildNavigateTitleContainer2 = this.guildNavigationBar;
        if (guildNavigateTitleContainer2 != null) {
        }
        guildHomeBanLayout2 = this.guildBanLayout;
        if (guildHomeBanLayout2 != null) {
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
        return onCreateView;
    }
}
