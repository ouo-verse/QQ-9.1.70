package com.tencent.mobileqq.guild.kuikly;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.UiThread;
import androidx.core.os.BundleKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.gamecenter.wadl.distribute.data.GameDistributeExtraInfo;
import com.tencent.kuikly.core.render.android.d;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.constant.GuildFacadeType;
import com.tencent.mobileqq.guild.homev2.fragments.GuildHomeV2Fragment;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.report.Reporters;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g;
import com.tencent.qphone.base.util.QLog;
import i01.c;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;
import wo1.ImageColorInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 S2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001+B\u000f\u0012\u0006\u0010P\u001a\u00020O\u00a2\u0006\u0004\bQ\u0010RJ\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J\u0012\u0010\u0015\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u0016\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J*\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00042\u0018\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u0018H\u0002J\u0018\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001dH\u0016JI\u0010'\u001a\u0004\u0018\u00010\u001d2\u0006\u0010 \u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042+\u0010&\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u001d\u00a2\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u0006\u0018\u00010!j\u0004\u0018\u0001`%H\u0016J\b\u0010(\u001a\u00020\u0006H\u0016J\u0018\u0010+\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010*\u001a\u00020)H\u0016R \u0010/\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00102\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00105\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u0010\u0017\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00104R\u0016\u00108\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00104R\u0016\u0010:\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u00104R\u0016\u0010=\u001a\u00020;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010<R\u0016\u0010>\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u00104R\u0016\u0010?\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u00104R\u0016\u0010@\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u00104R\u0016\u0010A\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u00104R\u0016\u0010B\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u00104R\u0018\u0010C\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u00104R\u0018\u0010G\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR;\u0010J\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u001d\u00a2\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u0006\u0018\u00010!j\u0004\u0018\u0001`%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010L\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u00104R\u0016\u0010N\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u00104\u00a8\u0006T"}, d2 = {"Lcom/tencent/mobileqq/guild/kuikly/GameGuildView;", "Landroid/widget/FrameLayout;", "Li01/c;", "Lwo1/a;", "", "params", "", "E", "G", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", UserInfo.SEX_FEMALE, "Landroid/app/Activity;", "fragmentActivity", "Landroidx/fragment/app/FragmentManager;", "B", "Lcom/tencent/kuikly/core/render/android/a;", "renderContext", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/g;", "D", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", BdhLogUtil.LogTag.Tag_Conn, "H", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "guildId", "Lkotlin/Function2;", "", "block", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "propKey", "", "propValue", "b", "method", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "call", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lwo1/d;", "info", "a", "Ljava/lang/ref/WeakReference;", "d", "Ljava/lang/ref/WeakReference;", "fragmentManagerRef", "e", "Z", "mDestroy", "f", "Ljava/lang/String;", "categoryId", h.F, "i", "channelId", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "gameChannelId", "", "I", "isSupportSpark", "sparkTaskKey", QQBrowserActivity.APP_PARAM, "joinSignature", "mainSource", "subSource", "afterJoinJumpChannelId", "Lcom/tencent/mobileqq/guild/homev2/fragments/GuildHomeV2Fragment;", "J", "Lcom/tencent/mobileqq/guild/homev2/fragments/GuildHomeV2Fragment;", "guildHomeFragment", "K", "Lkotlin/jvm/functions/Function1;", "loadListenerCallback", "L", "attaReportData", "M", "scrollTop", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "N", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GameGuildView extends FrameLayout implements i01.c, wo1.a {

    /* renamed from: C, reason: from kotlin metadata */
    private int isSupportSpark;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private String sparkTaskKey;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private String extraParams;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private String joinSignature;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private String mainSource;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private String subSource;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private String afterJoinJumpChannelId;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private GuildHomeV2Fragment guildHomeFragment;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private Function1<Object, Unit> loadListenerCallback;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private String attaReportData;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private String scrollTop;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<FragmentManager> fragmentManagerRef;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private volatile boolean mDestroy;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String categoryId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String guildId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String channelId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String gameChannelId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameGuildView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.categoryId = "";
        this.guildId = "";
        this.channelId = "";
        this.gameChannelId = "";
        this.sparkTaskKey = "";
        this.extraParams = "";
        this.joinSignature = "";
        this.mainSource = "";
        this.subSource = "";
        this.afterJoinJumpChannelId = "";
        this.attaReportData = "";
        this.scrollTop = "";
        QLog.i("GameGuildView", 1, "GameGuildView init:" + this);
    }

    private final void A(String guildId, final Function2<? super Boolean, ? super String, Unit> block) {
        if (!ch.j0(guildId)) {
            QLog.i("GameGuildView", 1, "ensureGuildInfoCache is member");
            block.invoke(Boolean.TRUE, "");
        } else {
            GuildMainFrameUtils.i(guildId, null, 18, null, true, new Function1<GuildMainFrameUtils.GuildAndChannelInfoRsp, Unit>() { // from class: com.tencent.mobileqq.guild.kuikly.GameGuildView$ensureGuildInfoCache$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(GuildMainFrameUtils.GuildAndChannelInfoRsp guildAndChannelInfoRsp) {
                    invoke2(guildAndChannelInfoRsp);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull GuildMainFrameUtils.GuildAndChannelInfoRsp it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    QLog.i("GameGuildView", 1, "fetchGuildAndChannelInfo " + it.k() + " " + it.e());
                    block.invoke(Boolean.valueOf(it.l()), it.getJoinSig());
                }
            }, 10, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentManager B(Activity fragmentActivity) {
        FragmentManager fragmentManager;
        QPublicFragmentActivity qPublicFragmentActivity;
        QPublicBaseFragment fragment;
        WeakReference<FragmentManager> weakReference = this.fragmentManagerRef;
        FragmentManager fragmentManager2 = null;
        if (weakReference != null) {
            fragmentManager = weakReference.get();
        } else {
            fragmentManager = null;
        }
        if (fragmentManager != null) {
            return fragmentManager;
        }
        try {
            if (fragmentActivity instanceof QPublicFragmentActivity) {
                qPublicFragmentActivity = (QPublicFragmentActivity) fragmentActivity;
            } else {
                qPublicFragmentActivity = null;
            }
            if (qPublicFragmentActivity != null && (fragment = qPublicFragmentActivity.getFragment()) != null) {
                fragmentManager = fragment.getChildFragmentManager();
            } else {
                fragmentManager = null;
            }
            if (fragmentManager == null) {
                QPublicBaseFragment C = C(get_kuiklyRenderContext());
                if (C != null) {
                    fragmentManager2 = C.getChildFragmentManager();
                }
                try {
                    QLog.i("GameGuildView", 1, "getFragmentManager use KuiklyFragment");
                    fragmentManager = fragmentManager2;
                } catch (Exception e16) {
                    FragmentManager fragmentManager3 = fragmentManager2;
                    e = e16;
                    fragmentManager = fragmentManager3;
                    QLog.e("GameGuildView", 1, "getFragmentManager e:", e);
                    if (fragmentActivity instanceof FragmentActivity) {
                        fragmentManager = ((FragmentActivity) fragmentActivity).getSupportFragmentManager();
                    }
                    this.fragmentManagerRef = new WeakReference<>(fragmentManager);
                    return fragmentManager;
                }
            }
        } catch (Exception e17) {
            e = e17;
        }
        this.fragmentManagerRef = new WeakReference<>(fragmentManager);
        return fragmentManager;
    }

    private final QPublicBaseFragment C(com.tencent.kuikly.core.render.android.a renderContext) {
        Object obj;
        QPublicBaseFragment qPublicBaseFragment;
        com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h hVar;
        i01.c cVar;
        com.tencent.kuikly.core.render.android.a aVar;
        g D = D(renderContext);
        com.tencent.kuikly.core.render.android.a aVar2 = null;
        if (D != null) {
            obj = D.getDelegate();
        } else {
            obj = null;
        }
        if (obj instanceof QPublicBaseFragment) {
            qPublicBaseFragment = (QPublicBaseFragment) obj;
        } else {
            qPublicBaseFragment = null;
        }
        if (qPublicBaseFragment != null) {
            return qPublicBaseFragment;
        }
        g D2 = D(renderContext);
        if (D2 != null) {
            hVar = D2.getDelegate();
        } else {
            hVar = null;
        }
        if (hVar instanceof i01.c) {
            cVar = (i01.c) hVar;
        } else {
            cVar = null;
        }
        if (cVar != null) {
            aVar = cVar.get_kuiklyRenderContext();
        } else {
            aVar = null;
        }
        if (aVar == null) {
            return null;
        }
        if (cVar != null) {
            aVar2 = cVar.get_kuiklyRenderContext();
        }
        Intrinsics.checkNotNull(aVar2);
        return C(aVar2);
    }

    private final g D(com.tencent.kuikly.core.render.android.a renderContext) {
        d O0;
        ViewGroup view;
        ViewParent viewParent = null;
        if (renderContext != null && (O0 = renderContext.O0()) != null && (view = O0.getView()) != null) {
            ViewParent parent = view.getParent();
            while (true) {
                if (parent == null) {
                    break;
                }
                if (parent instanceof g) {
                    viewParent = parent;
                    break;
                }
                parent = parent.getParent();
            }
        }
        return (g) viewParent;
    }

    private final void E(String params) {
        FragmentTransaction beginTransaction;
        QLog.i("GameGuildView", 1, "hideContent this:" + this);
        Activity activity = getActivity();
        if (activity != null) {
            synchronized (this) {
                if (this.mDestroy) {
                    QLog.i("GameGuildView", 1, "hideContent but view is mDestroy!");
                    return;
                }
                if (this.guildHomeFragment != null) {
                    FragmentManager B = B(activity);
                    if (B != null && (beginTransaction = B.beginTransaction()) != null) {
                        GuildHomeV2Fragment guildHomeV2Fragment = this.guildHomeFragment;
                        Intrinsics.checkNotNull(guildHomeV2Fragment);
                        FragmentTransaction hide = beginTransaction.hide(guildHomeV2Fragment);
                        if (hide != null) {
                            hide.commitAllowingStateLoss();
                        }
                    }
                } else {
                    QLog.e("GameGuildView", 1, "hideContent fragment is null");
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IPerformanceReportTask F() {
        return Reporters.f231995a.b().newReportTask().setEventCode("guild_main_page").setStageCode("stage_open").setParam("guild_id", this.guildId).setEnterFrom(GuildFacadeType.GameCenter.toString()).setAppChannel(com.tencent.mobileqq.guild.report.b.c()).report();
    }

    private final void G(String params) {
        boolean z16;
        QLog.i("GameGuildView", 1, "showContent this:" + this);
        if (this.guildId.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.i("GameGuildView", 1, "showContent guildId is empty");
        } else {
            A(this.guildId, new Function2<Boolean, String, Unit>() { // from class: com.tencent.mobileqq.guild.kuikly.GameGuildView$showContent$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, String str) {
                    invoke(bool.booleanValue(), str);
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z17, @NotNull String joinSig) {
                    Activity activity;
                    boolean z18;
                    GuildHomeV2Fragment guildHomeV2Fragment;
                    FragmentManager B;
                    FragmentTransaction beginTransaction;
                    GuildHomeV2Fragment guildHomeV2Fragment2;
                    String str;
                    String str2;
                    String str3;
                    String str4;
                    String str5;
                    String str6;
                    String str7;
                    String str8;
                    String str9;
                    int i3;
                    String str10;
                    String str11;
                    IPerformanceReportTask F;
                    GuildHomeV2Fragment guildHomeV2Fragment3;
                    FragmentManager B2;
                    FragmentTransaction beginTransaction2;
                    GuildHomeV2Fragment guildHomeV2Fragment4;
                    String str12;
                    Intrinsics.checkNotNullParameter(joinSig, "joinSig");
                    if (z17 && (activity = GameGuildView.this.getActivity()) != null) {
                        GameGuildView gameGuildView = GameGuildView.this;
                        if (activity.isFinishing() || activity.isDestroyed()) {
                            return;
                        }
                        synchronized (gameGuildView) {
                            z18 = gameGuildView.mDestroy;
                            if (!z18) {
                                guildHomeV2Fragment = gameGuildView.guildHomeFragment;
                                if (guildHomeV2Fragment != null) {
                                    B = gameGuildView.B(activity);
                                    if (B != null && (beginTransaction = B.beginTransaction()) != null) {
                                        guildHomeV2Fragment2 = gameGuildView.guildHomeFragment;
                                        Intrinsics.checkNotNull(guildHomeV2Fragment2);
                                        FragmentTransaction show = beginTransaction.show(guildHomeV2Fragment2);
                                        if (show != null) {
                                            show.commitAllowingStateLoss();
                                        }
                                    }
                                } else {
                                    View inflate = LayoutInflater.from(gameGuildView.getContext()).inflate(R.layout.f168096es3, (ViewGroup) null, false);
                                    inflate.setId(gameGuildView.hashCode());
                                    gameGuildView.addView(inflate, new FrameLayout.LayoutParams(-1, -1));
                                    str = gameGuildView.guildId;
                                    str2 = gameGuildView.channelId;
                                    str3 = gameGuildView.mainSource;
                                    str4 = gameGuildView.subSource;
                                    JumpGuildParam jumpGuildParam = new JumpGuildParam(str, str2, joinSig, str3, str4);
                                    str5 = gameGuildView.categoryId;
                                    if (!TextUtils.isEmpty(str5)) {
                                        a aVar = a.f226430a;
                                        str12 = gameGuildView.categoryId;
                                        jumpGuildParam.setCategoryId(aVar.a(str12, 0L));
                                    }
                                    JumpGuildParam.JoinInfoParam joinInfoParam = jumpGuildParam.getJoinInfoParam();
                                    str6 = gameGuildView.afterJoinJumpChannelId;
                                    joinInfoParam.setAfterJoinJumpChannelId(str6);
                                    jumpGuildParam.extras.putSerializable("guild_facade_type", GuildFacadeType.GameCenter);
                                    Bundle bundle = jumpGuildParam.extras;
                                    str7 = gameGuildView.scrollTop;
                                    bundle.putString("scrollTop", str7);
                                    Bundle bundle2 = jumpGuildParam.extras;
                                    str8 = gameGuildView.attaReportData;
                                    str9 = gameGuildView.gameChannelId;
                                    i3 = gameGuildView.isSupportSpark;
                                    str10 = gameGuildView.sparkTaskKey;
                                    str11 = gameGuildView.extraParams;
                                    bundle2.putSerializable(GameDistributeExtraInfo.EXTRA_KEY, new GameDistributeExtraInfo(true, str8, str9, i3, str10, str11));
                                    jumpGuildParam.extras.putBoolean("V2", true);
                                    GuildHomeV2Fragment guildHomeV2Fragment5 = new GuildHomeV2Fragment();
                                    Bundle bundleOf = BundleKt.bundleOf(TuplesKt.to(JumpGuildParam.KEY_JUMP_GUILD_PARAM, jumpGuildParam));
                                    F = gameGuildView.F();
                                    guildHomeV2Fragment5.setArguments(qw1.b.u(bundleOf, F, null, 2, null));
                                    gameGuildView.guildHomeFragment = guildHomeV2Fragment5;
                                    guildHomeV2Fragment3 = gameGuildView.guildHomeFragment;
                                    if (guildHomeV2Fragment3 != null) {
                                        guildHomeV2Fragment3.Fh(gameGuildView);
                                    }
                                    B2 = gameGuildView.B(activity);
                                    if (B2 != null && (beginTransaction2 = B2.beginTransaction()) != null) {
                                        int id5 = inflate.getId();
                                        guildHomeV2Fragment4 = gameGuildView.guildHomeFragment;
                                        Intrinsics.checkNotNull(guildHomeV2Fragment4);
                                        FragmentTransaction add = beginTransaction2.add(id5, guildHomeV2Fragment4);
                                        if (add != null) {
                                            add.commitAllowingStateLoss();
                                        }
                                    }
                                }
                                return;
                            }
                            QLog.i("GameGuildView", 1, "showContent but view is mDestroy!");
                        }
                    }
                }
            });
        }
    }

    private final void H(String params) {
        boolean z16 = true;
        QLog.i("GameGuildView", 1, "updateContent this:" + this);
        if (params == null) {
            params = "";
        }
        JSONObject jSONObject = new JSONObject(params);
        String guildId = jSONObject.optString("guildId");
        String optString = jSONObject.optString("channelId");
        String optString2 = jSONObject.optString("joinSignature");
        String optString3 = jSONObject.optString("mainSource");
        String optString4 = jSONObject.optString("subSource");
        String optString5 = jSONObject.optString("afterJoinJumpChannelId");
        String categoryId = jSONObject.optString("categoryId");
        final String optString6 = jSONObject.optString("scrollTop");
        String gameChannel = jSONObject.optString("gameChannelId");
        Intrinsics.checkNotNullExpressionValue(gameChannel, "gameChannel");
        if (gameChannel.length() <= 0) {
            z16 = false;
        }
        if (z16) {
            this.gameChannelId = gameChannel;
        }
        this.isSupportSpark = jSONObject.optInt("isSupportSpark");
        String optString7 = jSONObject.optString("sparkTaskKey");
        Intrinsics.checkNotNullExpressionValue(optString7, "paramsJson.optString(\"sparkTaskKey\")");
        this.sparkTaskKey = optString7;
        String optString8 = jSONObject.optString("attaReportData");
        Intrinsics.checkNotNullExpressionValue(optString8, "paramsJson.optString(\"attaReportData\")");
        this.attaReportData = optString8;
        String optString9 = jSONObject.optString(QQBrowserActivity.APP_PARAM);
        Intrinsics.checkNotNullExpressionValue(optString9, "paramsJson.optString(\"extraParams\")");
        this.extraParams = optString9;
        final JumpGuildParam jumpGuildParam = new JumpGuildParam(guildId, optString, optString2, optString3, optString4);
        if (!TextUtils.isEmpty(categoryId)) {
            a aVar = a.f226430a;
            Intrinsics.checkNotNullExpressionValue(categoryId, "categoryId");
            jumpGuildParam.setCategoryId(aVar.a(categoryId, 0L));
        }
        jumpGuildParam.getJoinInfoParam().setAfterJoinJumpChannelId(optString5);
        Intrinsics.checkNotNullExpressionValue(guildId, "guildId");
        A(guildId, new Function2<Boolean, String, Unit>() { // from class: com.tencent.mobileqq.guild.kuikly.GameGuildView$updateContent$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, String str) {
                invoke(bool.booleanValue(), str);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:36:0x00f2, code lost:
            
                r13 = r2.guildHomeFragment;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke(boolean z17, @NotNull String joinSig) {
                String str;
                String str2;
                int i3;
                String str3;
                String str4;
                boolean z18;
                GuildHomeV2Fragment guildHomeV2Fragment;
                GuildHomeV2Fragment guildHomeV2Fragment2;
                GuildHomeV2Fragment guildHomeV2Fragment3;
                IPerformanceReportTask F;
                FragmentManager B;
                FragmentTransaction beginTransaction;
                GuildHomeV2Fragment guildHomeV2Fragment4;
                Intrinsics.checkNotNullParameter(joinSig, "joinSig");
                if (z17) {
                    JumpGuildParam.this.setJoinSignature(joinSig);
                    JumpGuildParam.this.extras.putBoolean("V2", true);
                    Activity activity = this.getActivity();
                    if (activity != null) {
                        JumpGuildParam jumpGuildParam2 = JumpGuildParam.this;
                        String str5 = optString6;
                        GameGuildView gameGuildView = this;
                        if (activity.isFinishing() || activity.isDestroyed()) {
                            return;
                        }
                        Bundle bundle = jumpGuildParam2.extras;
                        bundle.putSerializable("guild_facade_type", GuildFacadeType.GameCenter);
                        jumpGuildParam2.extras.putString("scrollTop", str5);
                        str = gameGuildView.attaReportData;
                        str2 = gameGuildView.gameChannelId;
                        i3 = gameGuildView.isSupportSpark;
                        str3 = gameGuildView.sparkTaskKey;
                        str4 = gameGuildView.extraParams;
                        bundle.putSerializable(GameDistributeExtraInfo.EXTRA_KEY, new GameDistributeExtraInfo(true, str, str2, i3, str3, str4));
                        synchronized (gameGuildView) {
                            z18 = gameGuildView.mDestroy;
                            if (!z18) {
                                guildHomeV2Fragment = gameGuildView.guildHomeFragment;
                                boolean z19 = false;
                                if (guildHomeV2Fragment != null) {
                                    guildHomeV2Fragment2 = gameGuildView.guildHomeFragment;
                                    if (guildHomeV2Fragment2 != null && guildHomeV2Fragment2.isAdded()) {
                                        z19 = true;
                                    }
                                    if (z19 && guildHomeV2Fragment3 != null) {
                                        guildHomeV2Fragment3.bi(jumpGuildParam2);
                                    }
                                    QLog.i("GameGuildView", 1, "updateContent real");
                                    Unit unit = Unit.INSTANCE;
                                } else {
                                    GuildHomeV2Fragment guildHomeV2Fragment5 = new GuildHomeV2Fragment();
                                    Bundle bundleOf = BundleKt.bundleOf(TuplesKt.to(JumpGuildParam.KEY_JUMP_GUILD_PARAM, jumpGuildParam2));
                                    F = gameGuildView.F();
                                    guildHomeV2Fragment5.setArguments(qw1.b.u(bundleOf, F, null, 2, null));
                                    gameGuildView.guildHomeFragment = guildHomeV2Fragment5;
                                    View inflate = LayoutInflater.from(gameGuildView.getContext()).inflate(R.layout.f168096es3, (ViewGroup) null, false);
                                    inflate.setId(gameGuildView.hashCode());
                                    gameGuildView.addView(inflate, new FrameLayout.LayoutParams(-1, -1));
                                    B = gameGuildView.B(activity);
                                    if (B != null && (beginTransaction = B.beginTransaction()) != null) {
                                        int id5 = inflate.getId();
                                        guildHomeV2Fragment4 = gameGuildView.guildHomeFragment;
                                        Intrinsics.checkNotNull(guildHomeV2Fragment4);
                                        FragmentTransaction add = beginTransaction.add(id5, guildHomeV2Fragment4);
                                        if (add != null) {
                                            add.commitAllowingStateLoss();
                                        }
                                    }
                                }
                                return;
                            }
                            QLog.i("GameGuildView", 1, "updateContent but view is mDestroy!");
                        }
                    }
                }
            }
        });
    }

    private final void z(String params) {
        String guildId;
        boolean z16 = true;
        QLog.i("GameGuildView", 1, "changeSubTab");
        String str = "";
        if (params == null) {
            params = "";
        }
        JSONObject jSONObject = new JSONObject(params);
        String optString = jSONObject.optString("guildId");
        String categoryId = jSONObject.optString("categoryId");
        if (this.guildHomeFragment == null) {
            QLog.e("GameGuildView", 1, "changeSubTab guildHomeFragment has not init!");
            return;
        }
        if (this.mDestroy) {
            QLog.i("GameGuildView", 1, "changeSubTab but view is mDestroy!");
            return;
        }
        GuildHomeV2Fragment guildHomeV2Fragment = this.guildHomeFragment;
        if (guildHomeV2Fragment != null) {
            if (optString.length() != 0) {
                z16 = false;
            }
            if (z16) {
                GuildHomeV2Fragment guildHomeV2Fragment2 = this.guildHomeFragment;
                if (guildHomeV2Fragment2 != null && (guildId = guildHomeV2Fragment2.getGuildId()) != null) {
                    str = guildId;
                }
                optString = str;
            }
            Intrinsics.checkNotNullExpressionValue(optString, "guildId.ifEmpty { guildH\u2026Fragment?.guildId ?: \"\" }");
            a aVar = a.f226430a;
            Intrinsics.checkNotNullExpressionValue(categoryId, "categoryId");
            guildHomeV2Fragment.ai(optString, aVar.a(categoryId, 0L));
        }
    }

    @Override // wo1.a
    public void a(@NotNull String guildId, @NotNull ImageColorInfo info) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(info, "info");
        QLog.i("GameGuildView", 1, "onLoaded guildId:" + guildId + " " + info);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("method", "coverLoaded");
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("guildId", guildId);
        jSONObject2.put("coverUrl", info.getCoverUrl());
        jSONObject2.put("mainColor", info.getMainColor());
        jSONObject2.put("isLightColor", info.getIsLightColor());
        Unit unit = Unit.INSTANCE;
        jSONObject.put("ret", jSONObject2);
        Function1<Object, Unit> function1 = this.loadListenerCallback;
        if (function1 != null) {
            function1.invoke(jSONObject);
        }
    }

    @Override // i01.c
    public boolean b(@NotNull String propKey, @NotNull Object propValue) {
        String str;
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Intrinsics.checkNotNullParameter(propValue, "propValue");
        QLog.i("GameGuildView", 1, "setProp propKey" + propKey + " propValue:" + propValue);
        switch (propKey.hashCode()) {
            case -1665030214:
                if (propKey.equals("loadListener")) {
                    this.loadListenerCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
                    return true;
                }
                break;
            case -1579259651:
                if (propKey.equals("sparkTaskKey")) {
                    this.sparkTaskKey = (String) propValue;
                    return true;
                }
                break;
            case -653063506:
                if (propKey.equals("joinSignature")) {
                    this.joinSignature = (String) propValue;
                    return true;
                }
                break;
            case -390110597:
                if (propKey.equals("subSource")) {
                    this.subSource = (String) propValue;
                    return true;
                }
                break;
            case 373494894:
                if (propKey.equals("guildId")) {
                    this.guildId = (String) propValue;
                    return true;
                }
                break;
            case 417780552:
                if (propKey.equals("scrollTop")) {
                    this.scrollTop = (String) propValue;
                    return true;
                }
                break;
            case 460417844:
                if (propKey.equals("mainSource")) {
                    this.mainSource = (String) propValue;
                    return true;
                }
                break;
            case 837485930:
                if (propKey.equals("afterJoinJumpChannelId")) {
                    this.afterJoinJumpChannelId = (String) propValue;
                    return true;
                }
                break;
            case 1262235062:
                if (propKey.equals(QQBrowserActivity.APP_PARAM)) {
                    this.extraParams = (String) propValue;
                    return true;
                }
                break;
            case 1296531129:
                if (propKey.equals("categoryId")) {
                    this.categoryId = (String) propValue;
                    return true;
                }
                break;
            case 1461735806:
                if (propKey.equals("channelId")) {
                    this.channelId = (String) propValue;
                    return true;
                }
                break;
            case 1977941656:
                if (propKey.equals("isSupportSpark")) {
                    this.isSupportSpark = ((Integer) propValue).intValue();
                    return true;
                }
                break;
            case 1978889644:
                if (propKey.equals("gameChannelId")) {
                    this.gameChannelId = (String) propValue;
                    return true;
                }
                break;
            case 2037898494:
                if (propKey.equals("attaReportData")) {
                    if (propValue instanceof String) {
                        str = (String) propValue;
                    } else {
                        str = null;
                    }
                    if (str == null) {
                        return false;
                    }
                    this.attaReportData = str;
                    return true;
                }
                break;
        }
        return c.a.p(this, propKey, propValue);
    }

    @Override // i01.a
    @Nullable
    public Object call(@NotNull String str, @Nullable Object obj, @Nullable Function1<Object, Unit> function1) {
        return c.a.a(this, str, obj, function1);
    }

    @Override // i01.c
    public void e(@NotNull ViewGroup viewGroup) {
        c.a.l(this, viewGroup);
    }

    @Override // i01.c
    @NotNull
    public View f() {
        return c.a.r(this);
    }

    @Override // i01.c, i01.a
    @Nullable
    public Activity getActivity() {
        return c.a.e(this);
    }

    @Override // i01.c, i01.a
    @Nullable
    /* renamed from: getKuiklyRenderContext */
    public com.tencent.kuikly.core.render.android.a get_kuiklyRenderContext() {
        return c.a.f(this);
    }

    @Override // i01.c
    @UiThread
    public void h() {
        c.a.n(this);
    }

    @Override // i01.c
    /* renamed from: k */
    public boolean getReusable() {
        return c.a.g(this);
    }

    @Override // i01.c
    public void n(@NotNull ViewGroup viewGroup) {
        c.a.i(this, viewGroup);
    }

    @Override // i01.a
    @UiThread
    public void onCreate() {
        c.a.j(this);
    }

    @Override // i01.c, i01.a
    public void onDestroy() {
        GuildHomeV2Fragment guildHomeV2Fragment;
        FragmentManager B;
        FragmentTransaction beginTransaction;
        FragmentTransaction remove;
        c.a.k(this);
        this.mDestroy = true;
        synchronized (this) {
            Activity activity = getActivity();
            if (activity != null) {
                GuildHomeV2Fragment guildHomeV2Fragment2 = this.guildHomeFragment;
                boolean z16 = false;
                if (guildHomeV2Fragment2 != null && guildHomeV2Fragment2.isAdded()) {
                    z16 = true;
                }
                if (z16 && (guildHomeV2Fragment = this.guildHomeFragment) != null && (B = B(activity)) != null && (beginTransaction = B.beginTransaction()) != null && (remove = beginTransaction.remove(guildHomeV2Fragment)) != null) {
                    remove.commitAllowingStateLoss();
                }
                this.guildHomeFragment = null;
                Unit unit = Unit.INSTANCE;
            }
        }
        QLog.i("GameGuildView", 1, "onDestroy this:" + this);
    }

    @Override // i01.c
    @UiThread
    public boolean s(@NotNull String str) {
        return c.a.m(this, str);
    }

    @Override // i01.c, i01.a
    public void setKuiklyRenderContext(@Nullable com.tencent.kuikly.core.render.android.a aVar) {
        c.a.o(this, aVar);
    }

    @Override // i01.c
    @UiThread
    public void setShadow(@NotNull i01.b bVar) {
        c.a.q(this, bVar);
    }

    @Override // i01.c, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        QLog.i("GameGuildView", 1, "method:" + method + " params:" + params);
        switch (method.hashCode()) {
            case -544419984:
                if (method.equals("updateContent")) {
                    H(params);
                    break;
                }
                break;
            case -91857659:
                if (method.equals("changeSubTab")) {
                    z(params);
                    break;
                }
                break;
            case 831119575:
                if (method.equals("hideContent")) {
                    E(params);
                    break;
                }
                break;
            case 1339689660:
                if (method.equals("showContent")) {
                    G(params);
                    break;
                }
                break;
        }
        return c.a.b(this, method, params, callback);
    }
}
