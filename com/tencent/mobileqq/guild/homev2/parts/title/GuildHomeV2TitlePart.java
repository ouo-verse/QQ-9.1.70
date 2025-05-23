package com.tencent.mobileqq.guild.homev2.parts.title;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.constant.GuildFacadeType;
import com.tencent.mobileqq.guild.homev2.parts.title.GuildHomeV2TitleClickHandler;
import com.tencent.mobileqq.guild.homev2.parts.title.view.GuildHomeV2TitleLayout;
import com.tencent.mobileqq.guild.homev2.viewmodels.GuildHomeViewModel;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016J\u0012\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0012\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/guild/homev2/parts/title/GuildHomeV2TitlePart;", "Lcom/tencent/mobileqq/guild/homev2/parts/a;", "", "initData", "W9", "", "titleAlpha", "aa", "Lcom/tencent/mobileqq/guild/homev2/viewmodels/GuildHomeViewModel$b;", "uiState", "Z9", "P9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "onPartPause", "Lcom/tencent/mobileqq/guild/homev2/parts/title/view/GuildHomeV2TitleLayout;", "e", "Lcom/tencent/mobileqq/guild/homev2/parts/title/view/GuildHomeV2TitleLayout;", "mTitleLayout", "Lcom/tencent/mobileqq/guild/homev2/parts/title/GuildHomeV2TitleClickHandler$b;", "S9", "()Lcom/tencent/mobileqq/guild/homev2/parts/title/GuildHomeV2TitleClickHandler$b;", "mClickCallback", "<init>", "()V", "f", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildHomeV2TitlePart extends com.tencent.mobileqq.guild.homev2.parts.a {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private GuildHomeV2TitleLayout mTitleLayout;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", NodeProps.ON_CLICK, "(Landroid/view/View;)V", "com/tencent/mobileqq/guild/base/extension/l", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f225984d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ GuildHomeV2TitlePart f225985e;

        public b(View view, GuildHomeV2TitlePart guildHomeV2TitlePart) {
            this.f225984d = view;
            this.f225985e = guildHomeV2TitlePart;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!o.c("fastClickGuard")) {
                this.f225985e.S9().onBackClick();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", NodeProps.ON_CLICK, "(Landroid/view/View;)V", "com/tencent/mobileqq/guild/base/extension/l", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f225986d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ GuildHomeV2TitlePart f225987e;

        public c(View view, GuildHomeV2TitlePart guildHomeV2TitlePart) {
            this.f225986d = view;
            this.f225987e = guildHomeV2TitlePart;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!o.c("fastClickGuard")) {
                this.f225987e.S9().b();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", NodeProps.ON_CLICK, "(Landroid/view/View;)V", "com/tencent/mobileqq/guild/base/extension/l", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class d implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f225988d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ GuildHomeV2TitlePart f225989e;

        public d(View view, GuildHomeV2TitlePart guildHomeV2TitlePart) {
            this.f225988d = view;
            this.f225989e = guildHomeV2TitlePart;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!o.c("fastClickGuard")) {
                this.f225989e.S9().a();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", NodeProps.ON_CLICK, "(Landroid/view/View;)V", "com/tencent/mobileqq/guild/base/extension/l", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class e implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f225990d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ GuildHomeV2TitlePart f225991e;

        public e(View view, GuildHomeV2TitlePart guildHomeV2TitlePart) {
            this.f225990d = view;
            this.f225991e = guildHomeV2TitlePart;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!o.c("fastClickGuard")) {
                this.f225991e.S9().d();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", NodeProps.ON_CLICK, "(Landroid/view/View;)V", "com/tencent/mobileqq/guild/base/extension/l", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class f implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f225992d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ GuildHomeV2TitlePart f225993e;

        public f(View view, GuildHomeV2TitlePart guildHomeV2TitlePart) {
            this.f225992d = view;
            this.f225993e = guildHomeV2TitlePart;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!o.c("fastClickGuard")) {
                this.f225993e.S9().f();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", NodeProps.ON_CLICK, "(Landroid/view/View;)V", "com/tencent/mobileqq/guild/base/extension/l", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class g implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f225994d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ GuildHomeV2TitlePart f225995e;

        public g(View view, GuildHomeV2TitlePart guildHomeV2TitlePart) {
            this.f225994d = view;
            this.f225995e = guildHomeV2TitlePart;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!o.c("fastClickGuard")) {
                this.f225995e.S9().c();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", NodeProps.ON_CLICK, "(Landroid/view/View;)V", "com/tencent/mobileqq/guild/base/extension/l", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class h implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f225996d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ GuildHomeV2TitlePart f225997e;

        public h(View view, GuildHomeV2TitlePart guildHomeV2TitlePart) {
            this.f225996d = view;
            this.f225997e = guildHomeV2TitlePart;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!o.c("fastClickGuard")) {
                this.f225997e.S9().c();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", NodeProps.ON_CLICK, "(Landroid/view/View;)V", "com/tencent/mobileqq/guild/base/extension/l", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class i implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f225998d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ GuildHomeV2TitlePart f225999e;

        public i(View view, GuildHomeV2TitlePart guildHomeV2TitlePart) {
            this.f225998d = view;
            this.f225999e = guildHomeV2TitlePart;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!o.c("fastClickGuard")) {
                this.f225999e.S9().c();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", NodeProps.ON_CLICK, "(Landroid/view/View;)V", "com/tencent/mobileqq/guild/base/extension/l", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class j implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f226000d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ GuildHomeV2TitlePart f226001e;

        public j(View view, GuildHomeV2TitlePart guildHomeV2TitlePart) {
            this.f226000d = view;
            this.f226001e = guildHomeV2TitlePart;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!o.c("fastClickGuard")) {
                this.f226001e.S9().e();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00028\u0000 \u0002*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00010\u0001H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"T", "Lef1/a;", "kotlin.jvm.PlatformType", "it", "", "a", "(Lef1/a;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class k<T> implements Observer {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Object f226002d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Observer f226003e;

        public k(Object obj, Observer observer) {
            this.f226002d = obj;
            this.f226003e = observer;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(ef1.a<T> aVar) {
            T b16;
            if (aVar != null && (b16 = aVar.b(this.f226002d)) != null) {
                this.f226003e.onChanged(b16);
            }
        }
    }

    private final void P9() {
        GuildHomeV2TitleLayout guildHomeV2TitleLayout = this.mTitleLayout;
        GuildHomeV2TitleLayout guildHomeV2TitleLayout2 = null;
        if (guildHomeV2TitleLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleLayout");
            guildHomeV2TitleLayout = null;
        }
        ImageView imageView = guildHomeV2TitleLayout.getMBinding().f442506b;
        Intrinsics.checkNotNullExpressionValue(imageView, "mTitleLayout.binding.btnBack");
        imageView.setOnClickListener(new b(imageView, this));
        GuildHomeV2TitleLayout guildHomeV2TitleLayout3 = this.mTitleLayout;
        if (guildHomeV2TitleLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleLayout");
            guildHomeV2TitleLayout3 = null;
        }
        ImageView imageView2 = guildHomeV2TitleLayout3.getMBinding().f442510f;
        Intrinsics.checkNotNullExpressionValue(imageView2, "mTitleLayout.binding.btnShare");
        imageView2.setOnClickListener(new c(imageView2, this));
        GuildHomeV2TitleLayout guildHomeV2TitleLayout4 = this.mTitleLayout;
        if (guildHomeV2TitleLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleLayout");
            guildHomeV2TitleLayout4 = null;
        }
        ImageView imageView3 = guildHomeV2TitleLayout4.getMBinding().f442508d;
        Intrinsics.checkNotNullExpressionValue(imageView3, "mTitleLayout.binding.btnMore");
        imageView3.setOnClickListener(new d(imageView3, this));
        GuildHomeV2TitleLayout guildHomeV2TitleLayout5 = this.mTitleLayout;
        if (guildHomeV2TitleLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleLayout");
            guildHomeV2TitleLayout5 = null;
        }
        ImageView imageView4 = guildHomeV2TitleLayout5.getMBinding().f442507c;
        Intrinsics.checkNotNullExpressionValue(imageView4, "mTitleLayout.binding.btnManage");
        imageView4.setOnClickListener(new e(imageView4, this));
        GuildHomeV2TitleLayout guildHomeV2TitleLayout6 = this.mTitleLayout;
        if (guildHomeV2TitleLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleLayout");
            guildHomeV2TitleLayout6 = null;
        }
        ImageView imageView5 = guildHomeV2TitleLayout6.getMBinding().f442509e;
        Intrinsics.checkNotNullExpressionValue(imageView5, "mTitleLayout.binding.btnSearch");
        imageView5.setOnClickListener(new f(imageView5, this));
        GuildHomeV2TitleLayout guildHomeV2TitleLayout7 = this.mTitleLayout;
        if (guildHomeV2TitleLayout7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleLayout");
            guildHomeV2TitleLayout7 = null;
        }
        RoundImageView roundImageView = guildHomeV2TitleLayout7.getMBinding().f442512h;
        Intrinsics.checkNotNullExpressionValue(roundImageView, "mTitleLayout.binding.guildAvatar");
        roundImageView.setOnClickListener(new g(roundImageView, this));
        GuildHomeV2TitleLayout guildHomeV2TitleLayout8 = this.mTitleLayout;
        if (guildHomeV2TitleLayout8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleLayout");
            guildHomeV2TitleLayout8 = null;
        }
        TextView textView = guildHomeV2TitleLayout8.getMBinding().f442521q;
        Intrinsics.checkNotNullExpressionValue(textView, "mTitleLayout.binding.guildNameTv");
        textView.setOnClickListener(new h(textView, this));
        GuildHomeV2TitleLayout guildHomeV2TitleLayout9 = this.mTitleLayout;
        if (guildHomeV2TitleLayout9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleLayout");
            guildHomeV2TitleLayout9 = null;
        }
        LinearLayout linearLayout = guildHomeV2TitleLayout9.getMBinding().f442518n;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "mTitleLayout.binding.guildMedalContainer");
        linearLayout.setOnClickListener(new i(linearLayout, this));
        GuildHomeV2TitleLayout guildHomeV2TitleLayout10 = this.mTitleLayout;
        if (guildHomeV2TitleLayout10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleLayout");
            guildHomeV2TitleLayout10 = null;
        }
        FrameLayout frameLayout = guildHomeV2TitleLayout10.getMBinding().f442515k;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "mTitleLayout.binding.guildLivingContainer");
        frameLayout.setOnClickListener(new j(frameLayout, this));
        GuildHomeV2TitleLayout guildHomeV2TitleLayout11 = this.mTitleLayout;
        if (guildHomeV2TitleLayout11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleLayout");
            guildHomeV2TitleLayout11 = null;
        }
        guildHomeV2TitleLayout11.getMBinding().f442522r.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.homev2.parts.title.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildHomeV2TitlePart.Q9(view);
            }
        });
        GuildHomeV2TitleLayout guildHomeV2TitleLayout12 = this.mTitleLayout;
        if (guildHomeV2TitleLayout12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleLayout");
            guildHomeV2TitleLayout12 = null;
        }
        guildHomeV2TitleLayout12.getMBinding().f442511g.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.homev2.parts.title.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildHomeV2TitlePart.R9(view);
            }
        });
        GuildHomeV2TitleLayout guildHomeV2TitleLayout13 = this.mTitleLayout;
        if (guildHomeV2TitleLayout13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleLayout");
            guildHomeV2TitleLayout13 = null;
        }
        VideoReport.setElementId(guildHomeV2TitleLayout13.getMBinding().f442506b, "em_sgrp_back_btn");
        GuildHomeV2TitleLayout guildHomeV2TitleLayout14 = this.mTitleLayout;
        if (guildHomeV2TitleLayout14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleLayout");
            guildHomeV2TitleLayout14 = null;
        }
        VideoReport.setElementId(guildHomeV2TitleLayout14.getMBinding().f442510f, "em_sgrp_cover_share");
        GuildHomeV2TitleLayout guildHomeV2TitleLayout15 = this.mTitleLayout;
        if (guildHomeV2TitleLayout15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleLayout");
            guildHomeV2TitleLayout15 = null;
        }
        VideoReport.setElementId(guildHomeV2TitleLayout15.getMBinding().f442508d, "em_sgrp_top_right_more");
        GuildHomeV2TitleLayout guildHomeV2TitleLayout16 = this.mTitleLayout;
        if (guildHomeV2TitleLayout16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleLayout");
            guildHomeV2TitleLayout16 = null;
        }
        VideoReport.setElementId(guildHomeV2TitleLayout16.getMBinding().f442507c, "em_sgrp_setting");
        GuildHomeV2TitleLayout guildHomeV2TitleLayout17 = this.mTitleLayout;
        if (guildHomeV2TitleLayout17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleLayout");
            guildHomeV2TitleLayout17 = null;
        }
        VideoReport.setElementId(guildHomeV2TitleLayout17.getMBinding().f442509e, "em_sgrp_search_channel_content");
        GuildHomeV2TitleLayout guildHomeV2TitleLayout18 = this.mTitleLayout;
        if (guildHomeV2TitleLayout18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleLayout");
            guildHomeV2TitleLayout18 = null;
        }
        VideoReport.setElementId(guildHomeV2TitleLayout18.getMBinding().f442512h, "em_sgrp_channel_avatar");
        GuildHomeV2TitleLayout guildHomeV2TitleLayout19 = this.mTitleLayout;
        if (guildHomeV2TitleLayout19 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleLayout");
            guildHomeV2TitleLayout19 = null;
        }
        VideoReport.setElementId(guildHomeV2TitleLayout19.getMBinding().f442521q, "em_sgrp_channel_name");
        GuildHomeV2TitleLayout guildHomeV2TitleLayout20 = this.mTitleLayout;
        if (guildHomeV2TitleLayout20 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleLayout");
            guildHomeV2TitleLayout20 = null;
        }
        VideoReport.setElementId(guildHomeV2TitleLayout20.getMBinding().f442518n, "em_sgrp_channel_medal");
        GuildHomeV2TitleLayout guildHomeV2TitleLayout21 = this.mTitleLayout;
        if (guildHomeV2TitleLayout21 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleLayout");
        } else {
            guildHomeV2TitleLayout2 = guildHomeV2TitleLayout21;
        }
        VideoReport.setElementId(guildHomeV2TitleLayout2.getMBinding().f442515k, "em_sgrp_stream_live");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GuildHomeV2TitleClickHandler.b S9() {
        return new GuildHomeV2TitleClickHandler(x9(), A9(), C9()).f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void W9() {
        LiveData<Boolean> S1 = C9().getLivingViewModel().S1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.homev2.parts.title.GuildHomeV2TitlePart$initLivingStatusData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                GuildHomeV2TitleLayout guildHomeV2TitleLayout;
                guildHomeV2TitleLayout = GuildHomeV2TitlePart.this.mTitleLayout;
                if (guildHomeV2TitleLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTitleLayout");
                    guildHomeV2TitleLayout = null;
                }
                Intrinsics.checkNotNullExpressionValue(it, "it");
                guildHomeV2TitleLayout.k(it.booleanValue());
            }
        };
        S1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.homev2.parts.title.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildHomeV2TitlePart.X9(Function1.this, obj);
            }
        });
        C9().getLivingViewModel().U1("initData");
        MutableLiveData<ef1.a<Boolean>> T = C9().T();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner2, "partHost.hostLifecycleOwner");
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.homev2.parts.title.GuildHomeV2TitlePart$initLivingStatusData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                com.tencent.mobileqq.guild.homev2.parts.title.viewmodel.g.f226031d.i(GuildHomeV2TitlePart.this.C9().getGuildId());
            }
        };
        T.observe(lifecycleOwner2, new k(this, new Observer() { // from class: com.tencent.mobileqq.guild.homev2.parts.title.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildHomeV2TitlePart.Y9(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z9(GuildHomeViewModel.GuildHomeUiState uiState) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        boolean z28;
        int i3;
        int i16;
        int i17;
        int i18;
        boolean z29;
        int i19;
        boolean z36;
        boolean z37;
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("GuildHomeV2TitlePart", "updateTitleUIVisible uiState:" + uiState);
        }
        IGProGuildInfo guildInfo = uiState.getGuildInfo();
        boolean z38 = true;
        if (!uiState.getIsLoading() && guildInfo != null) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && uiState.getIsBanedGuild()) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z16 && !z17 && guildInfo != null && !guildInfo.isMember() && !guildInfo.isVisibleForVisitor()) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (!z16 && !z17 && !z18 && guildInfo != null && !guildInfo.isMember()) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (!z16 && !z17 && guildInfo != null && guildInfo.isMember()) {
            z26 = true;
        } else {
            z26 = false;
        }
        GuildHomeV2TitleLayout guildHomeV2TitleLayout = this.mTitleLayout;
        GuildHomeV2TitleLayout guildHomeV2TitleLayout2 = null;
        if (guildHomeV2TitleLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleLayout");
            guildHomeV2TitleLayout = null;
        }
        RoundImageView roundImageView = guildHomeV2TitleLayout.getMBinding().f442512h;
        if (!z19 && !z26) {
            z27 = false;
        } else {
            z27 = true;
        }
        roundImageView.setClickable(z27);
        GuildHomeV2TitleLayout guildHomeV2TitleLayout3 = this.mTitleLayout;
        if (guildHomeV2TitleLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleLayout");
            guildHomeV2TitleLayout3 = null;
        }
        TextView textView = guildHomeV2TitleLayout3.getMBinding().f442521q;
        if (!z19 && !z26) {
            z28 = false;
        } else {
            z28 = true;
        }
        textView.setClickable(z28);
        if (!z19 && !z26) {
            i3 = 4;
        } else {
            i3 = 0;
        }
        GuildHomeV2TitleLayout guildHomeV2TitleLayout4 = this.mTitleLayout;
        if (guildHomeV2TitleLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleLayout");
            guildHomeV2TitleLayout4 = null;
        }
        guildHomeV2TitleLayout4.getMBinding().f442512h.setVisibility(i3);
        GuildHomeV2TitleLayout guildHomeV2TitleLayout5 = this.mTitleLayout;
        if (guildHomeV2TitleLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleLayout");
            guildHomeV2TitleLayout5 = null;
        }
        guildHomeV2TitleLayout5.getMBinding().f442520p.setVisibility(i3);
        GuildHomeV2TitleLayout guildHomeV2TitleLayout6 = this.mTitleLayout;
        if (guildHomeV2TitleLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleLayout");
            guildHomeV2TitleLayout6 = null;
        }
        TextView textView2 = guildHomeV2TitleLayout6.getMBinding().f442513i;
        Intrinsics.checkNotNullExpressionValue(textView2, "mTitleLayout.binding.guildBanNameTv");
        int i26 = 8;
        if (z17) {
            i16 = 0;
        } else {
            i16 = 8;
        }
        textView2.setVisibility(i16);
        GuildHomeV2TitleLayout guildHomeV2TitleLayout7 = this.mTitleLayout;
        if (guildHomeV2TitleLayout7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleLayout");
            guildHomeV2TitleLayout7 = null;
        }
        guildHomeV2TitleLayout7.getMBinding().f442509e.setClickable(z26);
        GuildHomeV2TitleLayout guildHomeV2TitleLayout8 = this.mTitleLayout;
        if (guildHomeV2TitleLayout8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleLayout");
            guildHomeV2TitleLayout8 = null;
        }
        ImageView imageView = guildHomeV2TitleLayout8.getMBinding().f442509e;
        Intrinsics.checkNotNullExpressionValue(imageView, "mTitleLayout.binding.btnSearch");
        if (z26) {
            i17 = 0;
        } else {
            i17 = 8;
        }
        imageView.setVisibility(i17);
        GuildHomeV2TitleLayout guildHomeV2TitleLayout9 = this.mTitleLayout;
        if (guildHomeV2TitleLayout9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleLayout");
            guildHomeV2TitleLayout9 = null;
        }
        guildHomeV2TitleLayout9.getMBinding().f442507c.setClickable(z26);
        GuildHomeV2TitleLayout guildHomeV2TitleLayout10 = this.mTitleLayout;
        if (guildHomeV2TitleLayout10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleLayout");
            guildHomeV2TitleLayout10 = null;
        }
        ImageView imageView2 = guildHomeV2TitleLayout10.getMBinding().f442507c;
        Intrinsics.checkNotNullExpressionValue(imageView2, "mTitleLayout.binding.btnManage");
        if (z26) {
            i18 = 0;
        } else {
            i18 = 8;
        }
        imageView2.setVisibility(i18);
        GuildHomeV2TitleLayout guildHomeV2TitleLayout11 = this.mTitleLayout;
        if (guildHomeV2TitleLayout11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleLayout");
            guildHomeV2TitleLayout11 = null;
        }
        ImageView imageView3 = guildHomeV2TitleLayout11.getMBinding().f442510f;
        Intrinsics.checkNotNullExpressionValue(imageView3, "mTitleLayout.binding.btnShare");
        if (!z18 && !z19) {
            z29 = false;
        } else {
            z29 = true;
        }
        if (z29) {
            i19 = 0;
        } else {
            i19 = 8;
        }
        imageView3.setVisibility(i19);
        GuildHomeV2TitleLayout guildHomeV2TitleLayout12 = this.mTitleLayout;
        if (guildHomeV2TitleLayout12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleLayout");
            guildHomeV2TitleLayout12 = null;
        }
        ImageView imageView4 = guildHomeV2TitleLayout12.getMBinding().f442510f;
        if (!z18 && !z19) {
            z36 = false;
        } else {
            z36 = true;
        }
        imageView4.setClickable(z36);
        GuildHomeV2TitleLayout guildHomeV2TitleLayout13 = this.mTitleLayout;
        if (guildHomeV2TitleLayout13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleLayout");
            guildHomeV2TitleLayout13 = null;
        }
        ImageView imageView5 = guildHomeV2TitleLayout13.getMBinding().f442508d;
        Intrinsics.checkNotNullExpressionValue(imageView5, "mTitleLayout.binding.btnMore");
        if (!z18 && !z19) {
            z37 = false;
        } else {
            z37 = true;
        }
        if (z37) {
            i26 = 0;
        }
        imageView5.setVisibility(i26);
        GuildHomeV2TitleLayout guildHomeV2TitleLayout14 = this.mTitleLayout;
        if (guildHomeV2TitleLayout14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleLayout");
        } else {
            guildHomeV2TitleLayout2 = guildHomeV2TitleLayout14;
        }
        ImageView imageView6 = guildHomeV2TitleLayout2.getMBinding().f442508d;
        if (!z18 && !z19) {
            z38 = false;
        }
        imageView6.setClickable(z38);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void aa(float titleAlpha) {
        boolean z16;
        GuildHomeV2TitleLayout guildHomeV2TitleLayout = this.mTitleLayout;
        GuildHomeV2TitleLayout guildHomeV2TitleLayout2 = null;
        if (guildHomeV2TitleLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleLayout");
            guildHomeV2TitleLayout = null;
        }
        guildHomeV2TitleLayout.getMBinding().f442512h.setAlpha(titleAlpha);
        GuildHomeV2TitleLayout guildHomeV2TitleLayout3 = this.mTitleLayout;
        if (guildHomeV2TitleLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleLayout");
            guildHomeV2TitleLayout3 = null;
        }
        guildHomeV2TitleLayout3.getMBinding().f442513i.setAlpha(titleAlpha);
        GuildHomeV2TitleLayout guildHomeV2TitleLayout4 = this.mTitleLayout;
        if (guildHomeV2TitleLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleLayout");
            guildHomeV2TitleLayout4 = null;
        }
        guildHomeV2TitleLayout4.getMBinding().f442520p.setAlpha(titleAlpha);
        GuildHomeV2TitleLayout guildHomeV2TitleLayout5 = this.mTitleLayout;
        if (guildHomeV2TitleLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleLayout");
            guildHomeV2TitleLayout5 = null;
        }
        guildHomeV2TitleLayout5.getMBinding().f442509e.setAlpha(titleAlpha);
        GuildHomeV2TitleLayout guildHomeV2TitleLayout6 = this.mTitleLayout;
        if (guildHomeV2TitleLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleLayout");
            guildHomeV2TitleLayout6 = null;
        }
        guildHomeV2TitleLayout6.getMBinding().f442507c.setAlpha(titleAlpha);
        GuildHomeV2TitleLayout guildHomeV2TitleLayout7 = this.mTitleLayout;
        if (guildHomeV2TitleLayout7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleLayout");
            guildHomeV2TitleLayout7 = null;
        }
        guildHomeV2TitleLayout7.getMBinding().f442510f.setAlpha(titleAlpha);
        GuildHomeV2TitleLayout guildHomeV2TitleLayout8 = this.mTitleLayout;
        if (guildHomeV2TitleLayout8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleLayout");
            guildHomeV2TitleLayout8 = null;
        }
        guildHomeV2TitleLayout8.getMBinding().f442508d.setAlpha(titleAlpha);
        GuildHomeV2TitleLayout guildHomeV2TitleLayout9 = this.mTitleLayout;
        if (guildHomeV2TitleLayout9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleLayout");
        } else {
            guildHomeV2TitleLayout2 = guildHomeV2TitleLayout9;
        }
        View view = guildHomeV2TitleLayout2.getMBinding().f442511g;
        Intrinsics.checkNotNullExpressionValue(view, "mTitleLayout.binding.disableClickViews");
        int i3 = 0;
        if (titleAlpha <= 0.01f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            i3 = 8;
        }
        view.setVisibility(i3);
    }

    private final void initData() {
        W9();
        LiveData<IGProGuildInfo> P1 = C9().getGuildInfoViewModel().P1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<IGProGuildInfo, Unit> function1 = new Function1<IGProGuildInfo, Unit>() { // from class: com.tencent.mobileqq.guild.homev2.parts.title.GuildHomeV2TitlePart$initData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IGProGuildInfo iGProGuildInfo) {
                invoke2(iGProGuildInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable IGProGuildInfo iGProGuildInfo) {
                GuildHomeV2TitleLayout guildHomeV2TitleLayout;
                guildHomeV2TitleLayout = GuildHomeV2TitlePart.this.mTitleLayout;
                if (guildHomeV2TitleLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTitleLayout");
                    guildHomeV2TitleLayout = null;
                }
                guildHomeV2TitleLayout.h(iGProGuildInfo);
            }
        };
        P1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.homev2.parts.title.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildHomeV2TitlePart.T9(Function1.this, obj);
            }
        });
        Flow onEach = FlowKt.onEach(C9().P1(), new GuildHomeV2TitlePart$initData$2(this, null));
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner2, "partHost.hostLifecycleOwner");
        FlowKt.launchIn(onEach, LifecycleOwnerKt.getLifecycleScope(lifecycleOwner2));
        Flow onEach2 = FlowKt.onEach(C9().a2(), new GuildHomeV2TitlePart$initData$3(this, null));
        LifecycleOwner lifecycleOwner3 = getPartHost().getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner3, "partHost.hostLifecycleOwner");
        FlowKt.launchIn(onEach2, LifecycleOwnerKt.getLifecycleScope(lifecycleOwner3));
        Flow onEach3 = FlowKt.onEach(C9().Q1(), new GuildHomeV2TitlePart$initData$4(this, null));
        LifecycleOwner lifecycleOwner4 = getPartHost().getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner4, "partHost.hostLifecycleOwner");
        FlowKt.launchIn(onEach3, LifecycleOwnerKt.getLifecycleScope(lifecycleOwner4));
        LiveData<Boolean> U1 = C9().O1().U1();
        LifecycleOwner lifecycleOwner5 = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.homev2.parts.title.GuildHomeV2TitlePart$initData$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                GuildHomeV2TitleLayout guildHomeV2TitleLayout;
                guildHomeV2TitleLayout = GuildHomeV2TitlePart.this.mTitleLayout;
                if (guildHomeV2TitleLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTitleLayout");
                    guildHomeV2TitleLayout = null;
                }
                guildHomeV2TitleLayout.f();
            }
        };
        U1.observe(lifecycleOwner5, new Observer() { // from class: com.tencent.mobileqq.guild.homev2.parts.title.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildHomeV2TitlePart.U9(Function1.this, obj);
            }
        });
        LiveData<Float> W1 = C9().O1().W1();
        LifecycleOwner lifecycleOwner6 = getPartHost().getLifecycleOwner();
        final Function1<Float, Unit> function13 = new Function1<Float, Unit>() { // from class: com.tencent.mobileqq.guild.homev2.parts.title.GuildHomeV2TitlePart$initData$6
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Float f16) {
                invoke2(f16);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Float titleAlpha) {
                GuildHomeV2TitlePart guildHomeV2TitlePart = GuildHomeV2TitlePart.this;
                Intrinsics.checkNotNullExpressionValue(titleAlpha, "titleAlpha");
                guildHomeV2TitlePart.aa(titleAlpha.floatValue());
            }
        };
        W1.observe(lifecycleOwner6, new Observer() { // from class: com.tencent.mobileqq.guild.homev2.parts.title.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildHomeV2TitlePart.V9(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.jp7);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.title_layout)");
        this.mTitleLayout = (GuildHomeV2TitleLayout) findViewById;
        if (B9().a() == GuildFacadeType.GameCenter) {
            GuildHomeV2TitleLayout guildHomeV2TitleLayout = this.mTitleLayout;
            if (guildHomeV2TitleLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleLayout");
                guildHomeV2TitleLayout = null;
            }
            guildHomeV2TitleLayout.setVisibility(8);
        }
        P9();
        initData();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(@Nullable Activity activity) {
        GuildHomeV2TitleLayout guildHomeV2TitleLayout = this.mTitleLayout;
        if (guildHomeV2TitleLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleLayout");
            guildHomeV2TitleLayout = null;
        }
        guildHomeV2TitleLayout.n(false);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        GuildHomeV2TitleLayout guildHomeV2TitleLayout = this.mTitleLayout;
        if (guildHomeV2TitleLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleLayout");
            guildHomeV2TitleLayout = null;
        }
        guildHomeV2TitleLayout.n(true);
    }
}
