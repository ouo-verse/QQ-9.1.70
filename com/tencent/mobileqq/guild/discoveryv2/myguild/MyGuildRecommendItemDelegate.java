package com.tencent.mobileqq.guild.discoveryv2.myguild;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.util.Consumer;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.qui.quitagview.QUITagSize;
import com.tencent.biz.qui.quitagview.QUITagType;
import com.tencent.biz.qui.quitagview.QUITagView;
import com.tencent.biz.qui.quitagview.QUITagViewConfig;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.image.URLDrawable;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.channel.joinchannel.JoinGuildLogic;
import com.tencent.mobileqq.guild.component.RoundImageView;
import com.tencent.mobileqq.guild.discovery.guildblockdetail.delegates.GuildRecommendGuildCardDelegate;
import com.tencent.mobileqq.guild.discovery.guildblockdetail.newrecommend.GuildRecommendGuildNewCardDelegate;
import com.tencent.mobileqq.guild.discovery.startpanel.childs.DiscoverTabType;
import com.tencent.mobileqq.guild.discoveryv2.myguild.MyGuildFragment;
import com.tencent.mobileqq.guild.discoveryv2.myguild.MyGuildRecommendItemDelegate;
import com.tencent.mobileqq.guild.jump.GuildJumpUtil;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.at;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildResult;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.listitem.QUIListItemBackgroundType;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vh2.bv;
import vp1.cc;
import wh2.em;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 -2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0002./B\u0007\u00a2\u0006\u0004\b+\u0010,J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J \u0010\u0010\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0011H\u0014J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0011H\u0014J&\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00032\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0014J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH\u0014J&\u0010 \u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00042\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0016H\u0014J.\u0010\"\u001a\u00020\t2\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00042\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0014R$\u0010*\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/myguild/MyGuildRecommendItemDelegate;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/AbsListItemAdapterDelegate;", "Lcom/tencent/mobileqq/guild/discoveryv2/myguild/aa;", "Lcom/tencent/mobileqq/guild/discoveryv2/myguild/h;", "Lcom/tencent/mobileqq/guild/discoveryv2/myguild/MyGuildRecommendItemDelegate$a;", "Lcom/tencent/mobileqq/guild/discoveryv2/myguild/ai;", "strongerData", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "joinBtn", "", "D", "w", "", "isGuest", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "H", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "g", tl.h.F, PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "v", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, BdhLogUtil.LogTag.Tag_Conn, "", "payloads", "y", "data", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/mobileqq/guild/discoveryv2/myguild/MyGuildFragment$b;", "d", "Lcom/tencent/mobileqq/guild/discoveryv2/myguild/MyGuildFragment$b;", "getIoc", "()Lcom/tencent/mobileqq/guild/discoveryv2/myguild/MyGuildFragment$b;", "setIoc", "(Lcom/tencent/mobileqq/guild/discoveryv2/myguild/MyGuildFragment$b;)V", "ioc", "<init>", "()V", "e", "Companion", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class MyGuildRecommendItemDelegate extends AbsListItemAdapterDelegate<MyGuildRecommendData, h, a> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name */
    private static int f217521f = QQGuildUIUtil.f(14.0f);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MyGuildFragment.b ioc;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0016\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0004J\u001e\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\"\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/myguild/MyGuildRecommendItemDelegate$Companion;", "", "", "guildName", "Landroid/widget/TextView;", "guildNameView", "Lcom/tencent/image/URLDrawable;", "urlDrawable", "", "c", "", "resId", "d", "officialIconUrl", "e", "OFFICIAL_ICON_HEIGHT", "I", "b", "()I", "setOFFICIAL_ICON_HEIGHT", "(I)V", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void c(String guildName, TextView guildNameView, URLDrawable urlDrawable) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) (guildName + " "));
            spannableStringBuilder.append(" ", new GuildRecommendGuildNewCardDelegate.a(urlDrawable), 33);
            guildNameView.setText(spannableStringBuilder);
        }

        public final int b() {
            return MyGuildRecommendItemDelegate.f217521f;
        }

        public final void d(int resId, @NotNull TextView guildName) {
            Intrinsics.checkNotNullParameter(guildName, "guildName");
            Drawable icon = guildName.getResources().getDrawable(resId);
            icon.setBounds(0, 0, QQGuildUIUtil.f(26.0f), QQGuildUIUtil.f(14.0f));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) (((Object) guildName.getText()) + " "));
            Intrinsics.checkNotNullExpressionValue(icon, "icon");
            spannableStringBuilder.append(" ", new GuildRecommendGuildNewCardDelegate.a(icon), 33);
            guildName.setText(spannableStringBuilder);
        }

        public final void e(@NotNull String officialIconUrl, @NotNull final String guildName, @NotNull final TextView guildNameView) {
            boolean z16;
            Intrinsics.checkNotNullParameter(officialIconUrl, "officialIconUrl");
            Intrinsics.checkNotNullParameter(guildName, "guildName");
            Intrinsics.checkNotNullParameter(guildNameView, "guildNameView");
            if (officialIconUrl.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                com.tencent.mobileqq.guild.util.an.INSTANCE.e(new WeakReference<>(guildNameView), new Function2<URLDrawable, Integer, Unit>() { // from class: com.tencent.mobileqq.guild.discoveryv2.myguild.MyGuildRecommendItemDelegate$Companion$updateOfficialIcon$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(URLDrawable uRLDrawable, Integer num) {
                        invoke(uRLDrawable, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull URLDrawable urlDrawable, int i3) {
                        Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
                        MyGuildRecommendItemDelegate.INSTANCE.c(guildName, guildNameView, urlDrawable);
                    }
                }, b());
            }
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0018B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\u0017\u0010\n\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/myguild/MyGuildRecommendItemDelegate$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "onViewAttachedToWindow", "onViewDetachedFromWindow", "Lvp1/cc;", "E", "Lvp1/cc;", "o", "()Lvp1/cc;", "binding", "Landroidx/core/util/Consumer;", "", UserInfo.SEX_FEMALE, "Landroidx/core/util/Consumer;", "getCb", "()Landroidx/core/util/Consumer;", "cb", "Lcom/tencent/mobileqq/guild/discoveryv2/myguild/MyGuildRecommendItemDelegate$a$a;", "G", "Lcom/tencent/mobileqq/guild/discoveryv2/myguild/MyGuildRecommendItemDelegate$a$a;", "observer", "<init>", "(Lvp1/cc;)V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final cc binding;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final Consumer<String> cb;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private final C7727a observer;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u000b\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014R#\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u000b8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/myguild/MyGuildRecommendItemDelegate$a$a;", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "info", "", "sourceType", "", "onAddGuildWithInfo", "", "guildId", "onRemoveGuild", "Ljava/lang/ref/WeakReference;", "Landroidx/core/util/Consumer;", "d", "Ljava/lang/ref/WeakReference;", "getCb", "()Ljava/lang/ref/WeakReference;", "cb", "<init>", "(Ljava/lang/ref/WeakReference;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.discoveryv2.myguild.MyGuildRecommendItemDelegate$a$a, reason: collision with other inner class name */
        /* loaded from: classes13.dex */
        public static final class C7727a extends GPServiceObserver {

            /* renamed from: d, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private final WeakReference<Consumer<String>> cb;

            public C7727a(@NotNull WeakReference<Consumer<String>> cb5) {
                Intrinsics.checkNotNullParameter(cb5, "cb");
                this.cb = cb5;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
            public void onAddGuildWithInfo(@Nullable IGProGuildInfo info, int sourceType) {
                Consumer<String> consumer;
                if (info != null && (consumer = this.cb.get()) != null) {
                    consumer.accept(info.getGuildID());
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
            public void onRemoveGuild(@Nullable String guildId) {
                Consumer<String> consumer = this.cb.get();
                if (consumer != null) {
                    consumer.accept(guildId);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull cc binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
            Consumer<String> consumer = new Consumer() { // from class: com.tencent.mobileqq.guild.discoveryv2.myguild.ah
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    MyGuildRecommendItemDelegate.a.m(MyGuildRecommendItemDelegate.a.this, (String) obj);
                }
            };
            this.cb = consumer;
            this.observer = new C7727a(new WeakReference(consumer));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void m(a this$0, String guild2) {
            Consumer consumer;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(guild2, "guild");
            QLog.i("MyGuildRecommendItemDelegate", 1, "updateJoinBtn guildId=" + guild2);
            Object tag = this$0.binding.f442681g.getTag();
            if (tag instanceof Consumer) {
                consumer = (Consumer) tag;
            } else {
                consumer = null;
            }
            if (consumer != null) {
                consumer.accept(guild2);
            }
        }

        @NotNull
        /* renamed from: o, reason: from getter */
        public final cc getBinding() {
            return this.binding;
        }

        public final void onViewAttachedToWindow() {
            IGPSService d16 = at.d();
            if (d16 != null) {
                d16.addObserver(this.observer);
            }
        }

        public final void onViewDetachedFromWindow() {
            IGPSService d16 = at.d();
            if (d16 != null) {
                d16.deleteObserver(this.observer);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(FrameLayout this_apply, MyGuildRecommendItemDelegate this$0, MyGuildRecommendStrongerData recommendStrongerData, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(recommendStrongerData, "$recommendStrongerData");
        if (!com.tencent.mobileqq.guild.util.o.c("fastClickGuard")) {
            this$0.w(recommendStrongerData);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(String finalGuild, MyGuildRecommendItemDelegate this$0, cc binding, String guild2) {
        Intrinsics.checkNotNullParameter(finalGuild, "$finalGuild");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(binding, "$binding");
        Intrinsics.checkNotNullParameter(guild2, "guild");
        if (Intrinsics.areEqual(guild2, finalGuild)) {
            boolean j06 = ch.j0(finalGuild);
            QLog.i("MyGuildRecommendItemDelegate", 1, "updateJoinBtn isGuest=" + j06);
            QUIButton qUIButton = binding.f442681g;
            Intrinsics.checkNotNullExpressionValue(qUIButton, "binding.joinButton");
            this$0.H(j06, qUIButton);
        }
    }

    private final void D(final MyGuildRecommendStrongerData strongerData, final QUIButton joinBtn) {
        joinBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.discoveryv2.myguild.ae
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyGuildRecommendItemDelegate.E(MyGuildRecommendStrongerData.this, joinBtn, this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(final MyGuildRecommendStrongerData strongerData, final QUIButton joinBtn, final MyGuildRecommendItemDelegate this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(strongerData, "$strongerData");
        Intrinsics.checkNotNullParameter(joinBtn, "$joinBtn");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (ch.j0(strongerData.getItem().getGuildId())) {
            JoinGuildLogic.JumpParam jumpParam = new JoinGuildLogic.JumpParam();
            jumpParam.d(!((IGuildTempApi) QRoute.api(IGuildTempApi.class)).isGuildTabSelected());
            jumpParam.c(true);
            com.tencent.mobileqq.guild.channel.joinchannel.h.a(joinBtn.getContext(), GuildRecommendGuildCardDelegate.Companion.g(GuildRecommendGuildCardDelegate.INSTANCE, strongerData.getTabType(), strongerData.getPageFrom(), strongerData.getItem().getGuildId(), strongerData.getItem().getChannelId(), strongerData.getItem().getJoinGuildSig(), null, null, 96, null), jumpParam, "MyGuildRecommendItemDelegate", new bv() { // from class: com.tencent.mobileqq.guild.discoveryv2.myguild.af
                @Override // vh2.bv
                public final void a(int i3, String str, IGProSecurityResult iGProSecurityResult, IGProJoinGuildResult iGProJoinGuildResult) {
                    MyGuildRecommendItemDelegate.F(MyGuildRecommendItemDelegate.this, joinBtn, strongerData, i3, str, iGProSecurityResult, iGProJoinGuildResult);
                }
            });
        } else {
            joinBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.discoveryv2.myguild.ag
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    MyGuildRecommendItemDelegate.G(MyGuildRecommendItemDelegate.this, strongerData, view2);
                }
            });
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(MyGuildRecommendItemDelegate this$0, QUIButton joinBtn, MyGuildRecommendStrongerData strongerData, int i3, String str, IGProSecurityResult iGProSecurityResult, IGProJoinGuildResult iGProJoinGuildResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(joinBtn, "$joinBtn");
        Intrinsics.checkNotNullParameter(strongerData, "$strongerData");
        if (com.tencent.mobileqq.guild.channel.joinchannel.h.d(i3, iGProSecurityResult)) {
            this$0.H(false, joinBtn);
            strongerData.d(2);
            this$0.w(strongerData);
            return;
        }
        com.tencent.mobileqq.guild.channel.joinchannel.h.c(BaseApplication.context, i3, str, iGProSecurityResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(MyGuildRecommendItemDelegate this$0, MyGuildRecommendStrongerData strongerData, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(strongerData, "$strongerData");
        if (!com.tencent.mobileqq.guild.util.o.c("fastClickGuard")) {
            this$0.w(strongerData);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final Context H(boolean isGuest, QUIButton joinBtn) {
        Context context = joinBtn.getContext();
        if (isGuest) {
            joinBtn.setText(context.getString(R.string.f155561hu));
        } else {
            joinBtn.setText(context.getString(R.string.f143610mj));
        }
        return context;
    }

    private final void w(MyGuildRecommendStrongerData strongerData) {
        ArrayList<String> arrayListOf;
        BaseApplication context = BaseApplication.context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        GuildRecommendGuildCardDelegate.Companion companion = GuildRecommendGuildCardDelegate.INSTANCE;
        GuildJumpUtil.n(context, GuildRecommendGuildCardDelegate.Companion.g(companion, strongerData.getTabType(), strongerData.getPageFrom(), strongerData.getItem().getGuildId(), strongerData.getItem().getChannelId(), strongerData.getItem().getJoinGuildSig(), null, null, 96, null));
        IGPSService iGPSService = (IGPSService) ch.R0(IGPSService.class);
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(strongerData.getItem().getGuildId());
        iGPSService.reportUserViewGuild(arrayListOf, mh1.a.c(mh1.a.f416777a, strongerData.getPageFrom(), null, 2, null), GuildRecommendGuildCardDelegate.Companion.c(companion, strongerData.getTabType(), strongerData.getPageFrom(), null, 4, null), 2, new em() { // from class: com.tencent.mobileqq.guild.discoveryv2.myguild.ad
            @Override // wh2.em
            public final void onResult(int i3, String str) {
                MyGuildRecommendItemDelegate.x(i3, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(int i3, String str) {
        if (i3 != 0) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str2 = "reportUserViewGuild failed result: " + i3 + ", errMsg: " + str;
            if (str2 instanceof String) {
                bVar.a().add(str2);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("MyGuildRecommendItemDelegate", 1, (String) it.next(), null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    @NotNull
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public a d(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        this.ioc = (MyGuildFragment.b) RFWIocAbilityProvider.g().getIocInterface(MyGuildFragment.b.class, parent, null);
        cc g16 = cc.g(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.f\u2026.context), parent, false)");
        return new a(g16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    public void g(@NotNull RecyclerView.ViewHolder holder) {
        a aVar;
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof a) {
            aVar = (a) holder;
        } else {
            aVar = null;
        }
        if (aVar == null) {
            return;
        }
        super.g(holder);
        ((a) holder).onViewAttachedToWindow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    public void h(@NotNull RecyclerView.ViewHolder holder) {
        a aVar;
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof a) {
            aVar = (a) holder;
        } else {
            aVar = null;
        }
        if (aVar == null) {
            return;
        }
        super.h(holder);
        ((a) holder).onViewDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public boolean j(@NotNull h item, @NotNull List<h> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return item instanceof MyGuildRecommendData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void l(@NotNull MyGuildRecommendData item, @NotNull a holder, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void m(@NotNull MyGuildRecommendData data, @NotNull a holder, @NotNull List<Object> payloads, int position) {
        boolean z16;
        boolean z17;
        DiscoverTabType discoverTabType;
        String str;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        final cc binding = holder.getBinding();
        binding.f442679e.setText(data.getTitle());
        List<String> h16 = data.h();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = h16.iterator();
        while (true) {
            z16 = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((String) next).length() <= 0) {
                z16 = false;
            }
            if (z16) {
                arrayList.add(next);
            }
        }
        if (!arrayList.isEmpty()) {
            TextView textView = binding.f442678d;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.guildDescription");
            textView.setVisibility(8);
            LinearLayout linearLayout = binding.f442680f;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.guildTagList");
            linearLayout.setVisibility(0);
            binding.f442680f.removeAllViews();
            int i3 = 0;
            for (Object obj : arrayList) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                Context context = holder.itemView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "holder.itemView.context");
                QUITagView qUITagView = new QUITagView(context, null, 2, null);
                qUITagView.setConfig(new QUITagViewConfig(QUITagType.FILL, QUITagSize.SMALL, null, (String) obj));
                binding.f442680f.addView(qUITagView);
                ViewGroup.LayoutParams layoutParams = qUITagView.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = com.tencent.biz.qui.quicommon.e.a(6.0f);
                i3 = i16;
            }
        } else {
            TextView textView2 = binding.f442678d;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.guildDescription");
            textView2.setVisibility(0);
            LinearLayout linearLayout2 = binding.f442680f;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.guildTagList");
            linearLayout2.setVisibility(8);
            binding.f442678d.setText(data.getDescription());
        }
        com.tencent.mobileqq.guild.util.v vVar = com.tencent.mobileqq.guild.util.v.f235697a;
        String avatarUrl = data.getAvatarUrl();
        RoundImageView roundImageView = binding.f442677c;
        Intrinsics.checkNotNullExpressionValue(roundImageView, "binding.guildAvatar");
        vVar.j(avatarUrl, roundImageView, new Function1<Option, Unit>() { // from class: com.tencent.mobileqq.guild.discoveryv2.myguild.MyGuildRecommendItemDelegate$onBindViewHolder$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Option option) {
                invoke2(option);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Option loadImage) {
                Intrinsics.checkNotNullParameter(loadImage, "$this$loadImage");
                loadImage.setFailedDrawableColor(0);
                loadImage.setLoadingDrawableColor(0);
            }
        });
        Companion companion = INSTANCE;
        String officialIconUrl = data.getOfficialIconUrl();
        String title = data.getTitle();
        TextView textView3 = binding.f442679e;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.guildName");
        companion.e(officialIconUrl, title, textView3);
        MyGuildFragment.b bVar = this.ioc;
        if (bVar != null && bVar.invoke().booleanValue()) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            discoverTabType = DiscoverTabType.ME;
        } else {
            discoverTabType = DiscoverTabType.DEFAULT;
        }
        final MyGuildRecommendStrongerData myGuildRecommendStrongerData = new MyGuildRecommendStrongerData(discoverTabType, 5, 2, data);
        QUIButton onBindViewHolder$lambda$3 = binding.f442681g;
        Intrinsics.checkNotNullExpressionValue(onBindViewHolder$lambda$3, "onBindViewHolder$lambda$3");
        onBindViewHolder$lambda$3.setPadding(0, 0, 0, 0);
        H(data.getIsGuest(), onBindViewHolder$lambda$3);
        D(myGuildRecommendStrongerData, onBindViewHolder$lambda$3);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("sgrp_channel_id", data.getGuildId());
        linkedHashMap.put(JumpGuildParam.EXTRA_KEY_TRACE_ID, data.getTraceId());
        linkedHashMap.put("sgrp_rank", Integer.valueOf(position));
        VideoReport.setElementParams(onBindViewHolder$lambda$3, linkedHashMap);
        MyGuildFragment.b bVar2 = this.ioc;
        if (bVar2 == null || !bVar2.invoke().booleanValue()) {
            z16 = false;
        }
        if (z16) {
            str = "em_sgrp_recommend_list_join";
        } else {
            str = "em_sgrp_join_channel_btn";
        }
        VideoReport.setElementId(onBindViewHolder$lambda$3, str);
        ClickPolicy clickPolicy = ClickPolicy.REPORT_ALL;
        VideoReport.setElementClickPolicy(onBindViewHolder$lambda$3, clickPolicy);
        final FrameLayout root = binding.getRoot();
        root.setTag(data.getGuildId());
        root.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.discoveryv2.myguild.ab
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyGuildRecommendItemDelegate.A(root, this, myGuildRecommendStrongerData, view);
            }
        });
        VideoReport.setElementReuseIdentifier(root, "MyGuildRecommendData" + position);
        VideoReport.setElementId(root, "em_sgrp_recommend_list");
        VideoReport.setElementClickPolicy(root, clickPolicy);
        VideoReport.setElementExposePolicy(root, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(root, EndExposurePolicy.REPORT_ALL);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.put("sgrp_channel_id", data.getGuildId());
        linkedHashMap2.put(JumpGuildParam.EXTRA_KEY_TRACE_ID, data.getTraceId());
        linkedHashMap2.put("sgrp_rank", Integer.valueOf(position));
        VideoReport.setElementParams(root, linkedHashMap2);
        View view = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        QUIListItemBackgroundType qUIListItemBackgroundType = QUIListItemBackgroundType.FullWidth;
        Context context2 = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "itemView.context");
        view.setBackground(qUIListItemBackgroundType.getBackground(context2, 1000));
        final String guildId = data.getGuildId();
        binding.f442681g.setTag(new Consumer() { // from class: com.tencent.mobileqq.guild.discoveryv2.myguild.ac
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj2) {
                MyGuildRecommendItemDelegate.B(guildId, this, binding, (String) obj2);
            }
        });
    }
}
