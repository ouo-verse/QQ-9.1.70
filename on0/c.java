package on0;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.guild.aio.article.title.userinfo.GuildArticleTitleUserInfoUIState;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.client.IGuildClientCommonApi;
import com.tencent.mobileqq.guild.picload.e;
import com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener;
import com.tencent.mobileqq.guild.util.ac;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProClientIdentityInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProIdentityInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.en;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import on0.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 >2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001?B\u0007\u00a2\u0006\u0004\b<\u0010=J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u001a\u0010\u0014\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u0006H\u0002J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0011H\u0002J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\bH\u0002J\u0010\u0010!\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u001fH\u0016J\u0016\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\"H\u0016J\b\u0010$\u001a\u00020\u0004H\u0016J\u0016\u0010'\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030&0%H\u0016J\u0010\u0010)\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0003H\u0016R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010;\u001a\u0002028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b:\u00104\u00a8\u0006@"}, d2 = {"Lon0/c;", "Lcom/tencent/aio/base/mvvm/a;", "Lon0/a;", "Lcom/tencent/guild/aio/article/title/userinfo/GuildArticleTitleUserInfoUIState;", "", "m1", "", "userNickName", "", "nickNameColor", "l1", "userTinyId", "guildId", "i1", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProClientIdentityInfo;", "userIdentityInfo", "j1", "Landroid/widget/ImageView;", "targetView", "url", ICustomDataEditor.NUMBER_PARAM_1, "gameImageView", "d1", "Landroid/view/View;", "v", "c1", "", "publishTime", "g1", "visibility", "f1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "Lcom/tencent/aio/base/mvvm/b;", "e1", "bindViewAndData", "", "Ljava/lang/Class;", "getObserverStates", "state", "h1", "Landroid/widget/RelativeLayout;", "d", "Landroid/widget/RelativeLayout;", "mUserInfoLayout", "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;", "e", "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;", "mUserAvatarView", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "mUserNickNameView", "Landroid/widget/FrameLayout;", h.F, "Landroid/widget/FrameLayout;", "mUserIdentityIdLayout", "i", "mPublishTimeView", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class c extends com.tencent.aio.base.mvvm.a<a, GuildArticleTitleUserInfoUIState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout mUserInfoLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private GuildUserAvatarView mUserAvatarView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView mUserNickNameView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private FrameLayout mUserIdentityIdLayout;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView mPublishTimeView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"on0/c$b", "Lcom/tencent/mobileqq/guild/picload/listener/GuildPicStateListener;", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "c", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b extends GuildPicStateListener {
        b() {
            super(true);
        }

        @Override // com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener
        public void c(@NotNull LoadState state, @NotNull Option option) {
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(option, "option");
        }
    }

    private final void c1(View v3) {
        if (v3.getParent() == null) {
            FrameLayout frameLayout = this.mUserIdentityIdLayout;
            if (frameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mUserIdentityIdLayout");
                frameLayout = null;
            }
            frameLayout.addView(v3);
        }
    }

    private final void d1(ImageView gameImageView) {
        ViewGroup.LayoutParams layoutParams = gameImageView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = ViewUtils.dpToPx(16.0f);
            gameImageView.setLayoutParams(layoutParams);
            gameImageView.setAdjustViewBounds(true);
        }
    }

    private final void f1(int visibility) {
        RelativeLayout relativeLayout = this.mUserInfoLayout;
        RelativeLayout relativeLayout2 = null;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserInfoLayout");
            relativeLayout = null;
        }
        if (relativeLayout.getVisibility() == 4 && visibility == 0) {
            RelativeLayout relativeLayout3 = this.mUserInfoLayout;
            if (relativeLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mUserInfoLayout");
                relativeLayout3 = null;
            }
            relativeLayout3.animate().cancel();
            RelativeLayout relativeLayout4 = this.mUserInfoLayout;
            if (relativeLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mUserInfoLayout");
                relativeLayout4 = null;
            }
            relativeLayout4.setVisibility(visibility);
            RelativeLayout relativeLayout5 = this.mUserInfoLayout;
            if (relativeLayout5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mUserInfoLayout");
                relativeLayout5 = null;
            }
            relativeLayout5.setAlpha(0.0f);
            RelativeLayout relativeLayout6 = this.mUserInfoLayout;
            if (relativeLayout6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mUserInfoLayout");
            } else {
                relativeLayout2 = relativeLayout6;
            }
            relativeLayout2.animate().alphaBy(1.0f).setDuration(300L).start();
            return;
        }
        RelativeLayout relativeLayout7 = this.mUserInfoLayout;
        if (relativeLayout7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserInfoLayout");
            relativeLayout7 = null;
        }
        if (relativeLayout7.getVisibility() == 0 && visibility == 4) {
            RelativeLayout relativeLayout8 = this.mUserInfoLayout;
            if (relativeLayout8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mUserInfoLayout");
                relativeLayout8 = null;
            }
            relativeLayout8.animate().cancel();
            RelativeLayout relativeLayout9 = this.mUserInfoLayout;
            if (relativeLayout9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mUserInfoLayout");
            } else {
                relativeLayout2 = relativeLayout9;
            }
            relativeLayout2.setVisibility(visibility);
        }
    }

    private final void g1(long publishTime) {
        TextView textView = this.mPublishTimeView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPublishTimeView");
            textView = null;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = getMContext().getResources().getString(R.string.f139740c3);
        Intrinsics.checkNotNullExpressionValue(string, "mContext.resources.getSt\u2026uild_article_publish_msg)");
        String format = String.format(string, Arrays.copyOf(new Object[]{en.t(getMContext(), publishTime * 1000)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        textView.setText(format);
    }

    private final void i1(String userTinyId, String guildId) {
        GuildUserAvatarView guildUserAvatarView = this.mUserAvatarView;
        if (guildUserAvatarView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserAvatarView");
            guildUserAvatarView = null;
        }
        guildUserAvatarView.setAvatarTinyId(guildId, userTinyId);
    }

    private final void j1(IGProClientIdentityInfo userIdentityInfo) {
        FrameLayout frameLayout = null;
        View inflate = LayoutInflater.from(getMContext()).inflate(R.layout.eeg, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) inflate;
        ImageView imageView = new ImageView(getMContext());
        IGProIdentityInfo b16 = ac.b(userIdentityInfo.getIdentityBytes());
        if (b16 != null && b16.getIdentityType() == 2) {
            textView.setVisibility(8);
            byte[] plateData = b16.getPlateData();
            Intrinsics.checkNotNullExpressionValue(plateData, "identityInfo.plateData");
            Resources resources = imageView.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "gameImageView.resources");
            Drawable c16 = ig1.a.c("", plateData, resources);
            if (c16 != null) {
                imageView.setImageDrawable(c16);
                imageView.setVisibility(0);
                c1(imageView);
                d1(imageView);
                FrameLayout frameLayout2 = this.mUserIdentityIdLayout;
                if (frameLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mUserIdentityIdLayout");
                } else {
                    frameLayout = frameLayout2;
                }
                frameLayout.setVisibility(0);
                imageView.setOnClickListener(new View.OnClickListener() { // from class: on0.b
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        c.k1(c.this, view);
                    }
                });
                VideoReport.setElementId(imageView, "em_sgrp_svip_medal");
                VideoReport.setElementClickPolicy(imageView, ClickPolicy.REPORT_ALL);
                VideoReport.setElementExposePolicy(imageView, ExposurePolicy.REPORT_ALL);
                return;
            }
        }
        int a16 = ac.a(userIdentityInfo.getIdentityBytes());
        if (a16 != 0) {
            if (a16 != 1) {
                if (!ac.c(userIdentityInfo)) {
                    FrameLayout frameLayout3 = this.mUserIdentityIdLayout;
                    if (frameLayout3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mUserIdentityIdLayout");
                    } else {
                        frameLayout = frameLayout3;
                    }
                    frameLayout.setVisibility(8);
                    return;
                }
                imageView.setVisibility(8);
                textView.setText(userIdentityInfo.getDesc());
                textView.setVisibility(0);
                c1(textView);
            } else {
                textView.setVisibility(8);
                String value = userIdentityInfo.getIdentityBytes().getIdentityList().get(0).getValue();
                n1(imageView, ((IGuildClientCommonApi) QRoute.api(IGuildClientCommonApi.class)).getClientIdentityIconPrefix() + value + "-m.png");
                imageView.setVisibility(0);
                c1(imageView);
                d1(imageView);
            }
        } else {
            imageView.setVisibility(8);
            textView.setText(userIdentityInfo.getIdentityBytes().getIdentityList().get(0).getValue());
            textView.setVisibility(0);
            c1(textView);
        }
        FrameLayout frameLayout4 = this.mUserIdentityIdLayout;
        if (frameLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserIdentityIdLayout");
        } else {
            frameLayout = frameLayout4;
        }
        frameLayout.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k1(c this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendIntent(new a.C10928a());
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void l1(String userNickName, int nickNameColor) {
        Resources resources;
        TextView textView = this.mUserNickNameView;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserNickNameView");
            textView = null;
        }
        textView.setText(userNickName);
        if (nickNameColor == -1) {
            Context mContext = getMContext();
            if (mContext != null && (resources = mContext.getResources()) != null) {
                TextView textView3 = this.mUserNickNameView;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mUserNickNameView");
                } else {
                    textView2 = textView3;
                }
                textView2.setTextColor(resources.getColor(R.color.blq));
                return;
            }
            return;
        }
        TextView textView4 = this.mUserNickNameView;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserNickNameView");
        } else {
            textView2 = textView4;
        }
        textView2.setTextColor(nickNameColor);
    }

    private final void m1() {
        TextView textView = this.mUserNickNameView;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserNickNameView");
            textView = null;
        }
        textView.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
        TextView textView3 = this.mUserNickNameView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserNickNameView");
        } else {
            textView2 = textView3;
        }
        textView2.getPaint().setStrokeWidth(1.0f);
    }

    private final void n1(ImageView targetView, String url) {
        if (targetView != null && !TextUtils.isEmpty(url)) {
            e.a().f(new Option().setUrl(url).setTargetView(targetView).setLoadingDrawable(null), new b());
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        super.bindViewAndData();
        m1();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @Nullable
    /* renamed from: e1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<a, GuildArticleTitleUserInfoUIState> getViewModel() {
        return new d();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<Class<? extends GuildArticleTitleUserInfoUIState>> getObserverStates() {
        List<Class<? extends GuildArticleTitleUserInfoUIState>> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{GuildArticleTitleUserInfoUIState.UserNickNameUIState.class, GuildArticleTitleUserInfoUIState.UserAvatarUIState.class, GuildArticleTitleUserInfoUIState.UserIdentityIdUIState.class, GuildArticleTitleUserInfoUIState.UserPublishTimeUIState.class, GuildArticleTitleUserInfoUIState.LayoutVisibilityUIState.class});
        return listOf;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: h1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull GuildArticleTitleUserInfoUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof GuildArticleTitleUserInfoUIState.UserNickNameUIState) {
            GuildArticleTitleUserInfoUIState.UserNickNameUIState userNickNameUIState = (GuildArticleTitleUserInfoUIState.UserNickNameUIState) state;
            l1(userNickNameUIState.getUserNickName(), userNickNameUIState.getNickNameColor());
            return;
        }
        if (state instanceof GuildArticleTitleUserInfoUIState.UserAvatarUIState) {
            GuildArticleTitleUserInfoUIState.UserAvatarUIState userAvatarUIState = (GuildArticleTitleUserInfoUIState.UserAvatarUIState) state;
            i1(userAvatarUIState.getUserTinyId(), userAvatarUIState.getGuildId());
        } else if (state instanceof GuildArticleTitleUserInfoUIState.UserIdentityIdUIState) {
            j1(((GuildArticleTitleUserInfoUIState.UserIdentityIdUIState) state).getUserIdentityInfo());
        } else if (state instanceof GuildArticleTitleUserInfoUIState.UserPublishTimeUIState) {
            g1(((GuildArticleTitleUserInfoUIState.UserPublishTimeUIState) state).getPublishTime());
        } else if (state instanceof GuildArticleTitleUserInfoUIState.LayoutVisibilityUIState) {
            f1(((GuildArticleTitleUserInfoUIState.LayoutVisibilityUIState) state).getVisibility());
        }
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        View findViewById = createViewParams.b().findViewById(R.id.klq);
        Intrinsics.checkNotNullExpressionValue(findViewById, "createViewParams.parent.\u2026Id(R.id.user_info_layout)");
        RelativeLayout relativeLayout = (RelativeLayout) findViewById;
        this.mUserInfoLayout = relativeLayout;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserInfoLayout");
            relativeLayout = null;
        }
        View findViewById2 = relativeLayout.findViewById(R.id.f115206ve);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mUserInfoLayout.findViewById(R.id.user_avatar)");
        this.mUserAvatarView = (GuildUserAvatarView) findViewById2;
        RelativeLayout relativeLayout2 = this.mUserInfoLayout;
        if (relativeLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserInfoLayout");
            relativeLayout2 = null;
        }
        View findViewById3 = relativeLayout2.findViewById(R.id.f115646wl);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mUserInfoLayout.findViewById(R.id.user_nick_name)");
        this.mUserNickNameView = (TextView) findViewById3;
        RelativeLayout relativeLayout3 = this.mUserInfoLayout;
        if (relativeLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserInfoLayout");
            relativeLayout3 = null;
        }
        View findViewById4 = relativeLayout3.findViewById(R.id.xhb);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "mUserInfoLayout.findViewById(R.id.identity_id)");
        this.mUserIdentityIdLayout = (FrameLayout) findViewById4;
        RelativeLayout relativeLayout4 = this.mUserInfoLayout;
        if (relativeLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserInfoLayout");
            relativeLayout4 = null;
        }
        View findViewById5 = relativeLayout4.findViewById(R.id.g5c);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "mUserInfoLayout.findViewById(R.id.publish_time)");
        this.mPublishTimeView = (TextView) findViewById5;
        RelativeLayout relativeLayout5 = this.mUserInfoLayout;
        if (relativeLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserInfoLayout");
            relativeLayout5 = null;
        }
        relativeLayout5.setVisibility(4);
        RelativeLayout relativeLayout6 = this.mUserInfoLayout;
        if (relativeLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserInfoLayout");
            return null;
        }
        return relativeLayout6;
    }
}
