package com.tencent.mobileqq.guild.discoveryv2.parts.statustitle.entrance;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.base.extension.g;
import com.tencent.mobileqq.guild.discoveryv2.parts.statustitle.entrance.GuildProfileEntrance;
import com.tencent.mobileqq.guild.mainframe.view.GuildDragTextView;
import com.tencent.mobileqq.guild.message.unread.UnreadInfo;
import com.tencent.mobileqq.guild.message.unread.api.IGuildTotalUnreadService;
import com.tencent.mobileqq.guild.profile.me.GuildMeFragment;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.TypefaceProvider;
import com.tencent.mobileqq.guild.util.at;
import com.tencent.mobileqq.guild.util.bw;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.IQQSearchApi;
import com.tencent.mobileqq.statustitle.UpdateLittleWorldEntry;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0002\u00145B\u0007\u00a2\u0006\u0004\b3\u00104J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0004H\u0016R\u0016\u0010\u001a\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u001cR\u0016\u0010 \u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u001fR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u001fR\u0016\u0010#\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001fR\u0016\u0010%\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010\u0019R\u0016\u0010'\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010\u001fR\u0016\u0010)\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010\u0019R\u0016\u0010+\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010\u0019R\u0016\u0010.\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/parts/statustitle/entrance/GuildProfileEntrance;", "Lgr2/a;", "Landroid/view/View;", "inflatedView", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "u", "v", "r", "", "unreadNum", "t", ReportConstant.COSTREPORT_PREFIX, "l", "p", "Lcom/tencent/biz/richframework/part/Part;", "ownerPart", "Landroid/view/ViewStub;", "viewStub", "b", "a", "", "color", "d", "c", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/mobileqq/guild/mainframe/view/GuildDragTextView;", "Lcom/tencent/mobileqq/guild/mainframe/view/GuildDragTextView;", "mUnreadText", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "mPersonalView", "mGuildSearch", "e", "mEntryForLittleWorldAuthor", "f", "mBtnEntryForLittleWorldAuthor", "g", "mRedDotForLittleWorldAuthor", h.F, "mBtnSearch", "i", "mBtnProfile", "j", "Lcom/tencent/biz/richframework/part/Part;", "mPart", "Lcom/tencent/mobileqq/guild/message/unread/UnreadInfo$a;", "k", "Lcom/tencent/mobileqq/guild/message/unread/UnreadInfo$a;", "mInboxUnreadInfo", "<init>", "()V", "TypefaceLoad", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildProfileEntrance implements gr2.a {

    /* renamed from: m, reason: collision with root package name */
    private static final int f217681m = QQGuildUIUtil.f(9.0f);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private View rootView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private GuildDragTextView mUnreadText;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private ImageView mPersonalView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ImageView mGuildSearch;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView mEntryForLittleWorldAuthor;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View mBtnEntryForLittleWorldAuthor;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private ImageView mRedDotForLittleWorldAuthor;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private View mBtnSearch;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private View mBtnProfile;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private Part mPart;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private UnreadInfo.a mInboxUnreadInfo;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0005\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0003\u001a\u00020\u0002R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/parts/statustitle/entrance/GuildProfileEntrance$TypefaceLoad;", "", "", "b", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/guild/discoveryv2/parts/statustitle/entrance/GuildProfileEntrance;", "a", "Ljava/lang/ref/WeakReference;", "weakEntranceRef", "guildProfileEntrance", "<init>", "(Lcom/tencent/mobileqq/guild/discoveryv2/parts/statustitle/entrance/GuildProfileEntrance;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class TypefaceLoad {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private WeakReference<GuildProfileEntrance> weakEntranceRef;

        public TypefaceLoad(@NotNull GuildProfileEntrance guildProfileEntrance) {
            Intrinsics.checkNotNullParameter(guildProfileEntrance, "guildProfileEntrance");
            this.weakEntranceRef = new WeakReference<>(guildProfileEntrance);
        }

        public final void b() {
            TypefaceProvider.d(MobileQQ.sMobileQQ.getApplicationContext(), "fonts/DIN-NextLT-Pro-QQ.ttf", new Function1<Typeface, Unit>() { // from class: com.tencent.mobileqq.guild.discoveryv2.parts.statustitle.entrance.GuildProfileEntrance$TypefaceLoad$loadTypeFace$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Typeface typeface) {
                    invoke2(typeface);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable Typeface typeface) {
                    WeakReference weakReference;
                    GuildDragTextView guildDragTextView;
                    if (typeface != null) {
                        weakReference = GuildProfileEntrance.TypefaceLoad.this.weakEntranceRef;
                        GuildProfileEntrance guildProfileEntrance = (GuildProfileEntrance) weakReference.get();
                        if (guildProfileEntrance != null) {
                            Intrinsics.checkNotNullExpressionValue(guildProfileEntrance, "this");
                            guildDragTextView = guildProfileEntrance.mUnreadText;
                            if (guildDragTextView == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mUnreadText");
                                guildDragTextView = null;
                            }
                            guildDragTextView.setTypeface(typeface);
                            guildProfileEntrance.mInboxUnreadInfo = null;
                            guildProfileEntrance.v();
                        }
                    }
                }
            });
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\b\u0003\u0010\n\u001aB\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00060\u0006 \u0003* \u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\u00070\u0005\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00002\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u0002H\n\u00a2\u0006\u0004\b\b\u0010\t"}, d2 = {"Landroid/view/View;", "T", "", "kotlin.jvm.PlatformType", "event", "", "", "", "getDynamicParams", "(Ljava/lang/String;)Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements IDynamicParams {
        public b() {
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        public final Map<String, Object> getDynamicParams(String event) {
            Integer num;
            Map mapOf;
            boolean z16;
            Intrinsics.checkNotNullExpressionValue(event, "event");
            UnreadInfo.a aVar = GuildProfileEntrance.this.mInboxUnreadInfo;
            if (aVar != null) {
                num = Integer.valueOf(aVar.b());
            } else {
                num = null;
            }
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_red_tips_type", num));
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : mapOf.entrySet()) {
                if (entry.getValue() != null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            return linkedHashMap;
        }
    }

    private final void l() {
        View view = this.mBtnSearch;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtnSearch");
            view = null;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.discoveryv2.parts.statustitle.entrance.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                GuildProfileEntrance.m(GuildProfileEntrance.this, view3);
            }
        });
        View view3 = this.mBtnProfile;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtnProfile");
            view3 = null;
        }
        view3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.discoveryv2.parts.statustitle.entrance.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                GuildProfileEntrance.n(GuildProfileEntrance.this, view4);
            }
        });
        View view4 = this.mBtnEntryForLittleWorldAuthor;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtnEntryForLittleWorldAuthor");
        } else {
            view2 = view4;
        }
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.discoveryv2.parts.statustitle.entrance.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view5) {
                GuildProfileEntrance.o(GuildProfileEntrance.this, view5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(GuildProfileEntrance this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!o.c("fastClickGuard")) {
            ((IQQSearchApi) QRoute.api(IQQSearchApi.class)).jump2SearchFromGuild(view.getContext());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(GuildProfileEntrance this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!o.c("fastClickGuard")) {
            GuildMeFragment.Companion companion = GuildMeFragment.INSTANCE;
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "it.context");
            companion.a(context);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(GuildProfileEntrance this$0, View view) {
        Activity activity;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!o.c("fastClickGuard")) {
            Context context = view.getContext();
            ImageView imageView = null;
            if (context instanceof Activity) {
                activity = (Activity) context;
            } else {
                activity = null;
            }
            if (activity != null) {
                ch.i1(activity, "https://qun.qq.com/guild/h5/guild-create-xsj/index.html?_wwv=139264&_wv=16785408");
                ImageView imageView2 = this$0.mRedDotForLittleWorldAuthor;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRedDotForLittleWorldAuthor");
                } else {
                    imageView = imageView2;
                }
                imageView.setVisibility(8);
                bw.f235485a.L1(false);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void p() {
        View view;
        View view2;
        View view3;
        View view4 = this.mBtnSearch;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtnSearch");
            view = null;
        } else {
            view = view4;
        }
        g.b(view, "em_sgrp_discover_search_btn", false, false, null, 14, null);
        View view5 = this.mBtnProfile;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtnProfile");
            view2 = null;
        } else {
            view2 = view5;
        }
        g.b(view2, "em_sgrp_more_action", false, false, null, 14, null);
        View view6 = this.mBtnProfile;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtnProfile");
            view6 = null;
        }
        VideoReport.setEventDynamicParams(view6, new b());
        View view7 = this.mBtnEntryForLittleWorldAuthor;
        if (view7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtnEntryForLittleWorldAuthor");
            view3 = null;
        } else {
            view3 = view7;
        }
        g.b(view3, "em_sgrp_migrate_xsj", false, false, null, 14, null);
    }

    private final void q(View inflatedView) {
        View findViewById = inflatedView.findViewById(R.id.wtm);
        Intrinsics.checkNotNullExpressionValue(findViewById, "inflatedView.findViewByI\u2026R.id.guild_personal_root)");
        this.rootView = findViewById;
        View findViewById2 = inflatedView.findViewById(R.id.xig);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "inflatedView.findViewById(R.id.image_guild_search)");
        this.mGuildSearch = (ImageView) findViewById2;
        View findViewById3 = inflatedView.findViewById(R.id.xji);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "inflatedView.findViewByI\u2026_for_little_world_author)");
        this.mEntryForLittleWorldAuthor = (ImageView) findViewById3;
        View findViewById4 = inflatedView.findViewById(R.id.wtn);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "inflatedView.findViewByI\u2026R.id.guild_personal_view)");
        this.mPersonalView = (ImageView) findViewById4;
        View findViewById5 = inflatedView.findViewById(R.id.wtp);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "inflatedView.findViewByI\u2026_personal_view_unread_tv)");
        this.mUnreadText = (GuildDragTextView) findViewById5;
        View view = this.rootView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        View findViewById6 = view.findViewById(R.id.aju);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.id.btn_search)");
        this.mBtnSearch = findViewById6;
        View view3 = this.rootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view3 = null;
        }
        View findViewById7 = view3.findViewById(R.id.tfy);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "rootView.findViewById(R.id.btn_profile)");
        this.mBtnProfile = findViewById7;
        View view4 = this.rootView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view4 = null;
        }
        View findViewById8 = view4.findViewById(R.id.tej);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "rootView.findViewById(R.\u2026_for_little_world_author)");
        this.mBtnEntryForLittleWorldAuthor = findViewById8;
        View view5 = this.rootView;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view5 = null;
        }
        View findViewById9 = view5.findViewById(R.id.f72043ps);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "rootView.findViewById(R.\u2026_for_little_world_author)");
        this.mRedDotForLittleWorldAuthor = (ImageView) findViewById9;
        GuildDragTextView guildDragTextView = this.mUnreadText;
        if (guildDragTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUnreadText");
            guildDragTextView = null;
        }
        View view6 = this.rootView;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
        } else {
            view2 = view6;
        }
        guildDragTextView.setDragViewType(2, view2);
        u();
        r();
        p();
        l();
    }

    private final void r() {
        new TypefaceLoad(this).b();
    }

    private final void s() {
        GuildDragTextView guildDragTextView = this.mUnreadText;
        GuildDragTextView guildDragTextView2 = null;
        if (guildDragTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUnreadText");
            guildDragTextView = null;
        }
        guildDragTextView.setText("");
        GuildDragTextView guildDragTextView3 = this.mUnreadText;
        if (guildDragTextView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUnreadText");
            guildDragTextView3 = null;
        }
        ViewGroup.LayoutParams layoutParams = guildDragTextView3.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        int i3 = f217681m;
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = i3;
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = i3;
        GuildDragTextView guildDragTextView4 = this.mUnreadText;
        if (guildDragTextView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUnreadText");
            guildDragTextView4 = null;
        }
        guildDragTextView4.setLayoutParams(layoutParams2);
        GuildDragTextView guildDragTextView5 = this.mUnreadText;
        if (guildDragTextView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUnreadText");
            guildDragTextView5 = null;
        }
        guildDragTextView5.setTranslationX(QQGuildUIUtil.f(-4.0f));
        GuildDragTextView guildDragTextView6 = this.mUnreadText;
        if (guildDragTextView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUnreadText");
            guildDragTextView6 = null;
        }
        guildDragTextView6.setTranslationY(QQGuildUIUtil.f(-4.0f));
        GuildDragTextView guildDragTextView7 = this.mUnreadText;
        if (guildDragTextView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUnreadText");
        } else {
            guildDragTextView2 = guildDragTextView7;
        }
        guildDragTextView2.setVisibility(0);
    }

    private final void t(long unreadNum) {
        String valueOf;
        GuildDragTextView guildDragTextView = this.mUnreadText;
        GuildDragTextView guildDragTextView2 = null;
        if (guildDragTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUnreadText");
            guildDragTextView = null;
        }
        if (unreadNum > 99) {
            valueOf = "99+";
        } else {
            valueOf = String.valueOf(unreadNum);
        }
        guildDragTextView.setText(valueOf);
        GuildDragTextView guildDragTextView3 = this.mUnreadText;
        if (guildDragTextView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUnreadText");
            guildDragTextView3 = null;
        }
        ViewGroup.LayoutParams layoutParams = guildDragTextView3.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = -2;
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = -2;
        GuildDragTextView guildDragTextView4 = this.mUnreadText;
        if (guildDragTextView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUnreadText");
            guildDragTextView4 = null;
        }
        guildDragTextView4.setLayoutParams(layoutParams2);
        GuildDragTextView guildDragTextView5 = this.mUnreadText;
        if (guildDragTextView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUnreadText");
            guildDragTextView5 = null;
        }
        guildDragTextView5.setTranslationX(QQGuildUIUtil.f(1.0f));
        GuildDragTextView guildDragTextView6 = this.mUnreadText;
        if (guildDragTextView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUnreadText");
            guildDragTextView6 = null;
        }
        guildDragTextView6.setTranslationY(QQGuildUIUtil.f(-6.0f));
        GuildDragTextView guildDragTextView7 = this.mUnreadText;
        if (guildDragTextView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUnreadText");
        } else {
            guildDragTextView2 = guildDragTextView7;
        }
        guildDragTextView2.setVisibility(0);
    }

    private final void u() {
        int i3;
        int i16 = 0;
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("106073", false);
        boolean z16 = true;
        QLog.i("GuildProfileEntrance", 1, "isUniteConfigSwitchOn=" + isSwitchOn);
        View view = this.mBtnEntryForLittleWorldAuthor;
        ImageView imageView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtnEntryForLittleWorldAuthor");
            view = null;
        }
        if (isSwitchOn) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
        SimpleEventBus.getInstance().dispatchEvent(new UpdateLittleWorldEntry(isSwitchOn));
        boolean a06 = bw.f235485a.a0();
        QLog.i("GuildProfileEntrance", 1, "isRedDotNeedShow=" + a06);
        ImageView imageView2 = this.mRedDotForLittleWorldAuthor;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRedDotForLittleWorldAuthor");
        } else {
            imageView = imageView2;
        }
        if (!a06 || !isSwitchOn) {
            z16 = false;
        }
        if (!z16) {
            i16 = 8;
        }
        imageView.setVisibility(i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v() {
        if (!at.c()) {
            return;
        }
        UnreadInfo.a mine = ((IGuildTotalUnreadService) ch.R0(IGuildTotalUnreadService.class)).getTotalCount().getMine();
        if (Intrinsics.areEqual(mine, this.mInboxUnreadInfo)) {
            return;
        }
        this.mInboxUnreadInfo = mine;
        QLog.d("GuildProfileEntrance", 1, "updateUnreadView ", mine);
        UnreadInfo.a aVar = this.mInboxUnreadInfo;
        if (aVar != null) {
            if (aVar.getCount() <= 0) {
                GuildDragTextView guildDragTextView = this.mUnreadText;
                if (guildDragTextView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mUnreadText");
                    guildDragTextView = null;
                }
                guildDragTextView.setVisibility(8);
                return;
            }
            if (aVar.getIsStrongUnread()) {
                t(aVar.getCount());
            } else {
                s();
            }
        }
    }

    @Override // gr2.a
    public void a() {
        ImageView imageView = this.mGuildSearch;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildSearch");
            imageView = null;
        }
        ImageView imageView3 = this.mGuildSearch;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildSearch");
            imageView3 = null;
        }
        imageView.setImageDrawable(imageView3.getResources().getDrawable(R.drawable.qui_search_icon_navigation_01_selector));
        ImageView imageView4 = this.mPersonalView;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPersonalView");
            imageView4 = null;
        }
        ImageView imageView5 = this.mPersonalView;
        if (imageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPersonalView");
            imageView5 = null;
        }
        imageView4.setImageDrawable(imageView5.getResources().getDrawable(R.drawable.guild_status_bar_drawer_icon_selector));
        ImageView imageView6 = this.mEntryForLittleWorldAuthor;
        if (imageView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEntryForLittleWorldAuthor");
            imageView6 = null;
        }
        ImageView imageView7 = this.mEntryForLittleWorldAuthor;
        if (imageView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEntryForLittleWorldAuthor");
        } else {
            imageView2 = imageView7;
        }
        imageView6.setImageDrawable(imageView2.getResources().getDrawable(R.drawable.guild_little_world_author_entry_selector));
    }

    @Override // gr2.a
    public void b(@NotNull Part ownerPart, @NotNull ViewStub viewStub) {
        Intrinsics.checkNotNullParameter(ownerPart, "ownerPart");
        Intrinsics.checkNotNullParameter(viewStub, "viewStub");
        this.mPart = ownerPart;
        viewStub.setLayoutResource(R.layout.exp);
        View inflate = viewStub.inflate();
        Intrinsics.checkNotNullExpressionValue(inflate, "viewStub.inflate()");
        q(inflate);
    }

    @Override // gr2.a
    public void c() {
        u();
    }

    @Override // gr2.a
    public void d(int color) {
        ImageView imageView = this.mPersonalView;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPersonalView");
            imageView = null;
        }
        imageView.setColorFilter(color);
        ImageView imageView3 = this.mGuildSearch;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildSearch");
            imageView3 = null;
        }
        imageView3.setColorFilter(color);
        ImageView imageView4 = this.mEntryForLittleWorldAuthor;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEntryForLittleWorldAuthor");
        } else {
            imageView2 = imageView4;
        }
        imageView2.setColorFilter(color);
    }
}
