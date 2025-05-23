package com.tencent.mobileqq.guild.quiprofile;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.GuildQUIProfileLayoutInflater;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import androidx.annotation.Keep;
import androidx.fragment.app.FragmentActivity;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.richframework.collection.RFWThreadLocal;
import com.tencent.mobileqq.app.QBaseActivityWrapper;
import com.tencent.mobileqq.app.utils.DisplayMetricsUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.argus.node.ArgusTag;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@ArgusTag(tags = {"CUSTOM_CONTEXT"})
@Keep
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u00002\u00020\u0001:\u0001\u0016B\u0011\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0017\u0010\u000b\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/quiprofile/GuildActivityWrapper;", "Lcom/tencent/mobileqq/app/QBaseActivityWrapper;", "Landroid/content/res/Resources;", "getResources", "Lcom/tencent/mobileqq/guild/quiprofile/c;", "createGuildProfileResources", "", "name", "", "getSystemService", "Landroidx/fragment/app/FragmentActivity;", PM.BASE, "Landroidx/fragment/app/FragmentActivity;", "getBase", "()Landroidx/fragment/app/FragmentActivity;", "Lcom/tencent/biz/richframework/collection/RFWThreadLocal;", "Landroid/view/LayoutInflater;", "currentLayoutInflaters", "Lcom/tencent/biz/richframework/collection/RFWThreadLocal;", "currentResource", "<init>", "(Landroidx/fragment/app/FragmentActivity;)V", "SupportVasThemeActivityWrapper", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public class GuildActivityWrapper extends QBaseActivityWrapper {

    @NotNull
    private final FragmentActivity base;

    @NotNull
    private RFWThreadLocal<LayoutInflater> currentLayoutInflaters;

    @NotNull
    private final RFWThreadLocal<c> currentResource;

    /* compiled from: P */
    @Keep
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0003\u001a\u00020\u0002H\u0014\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/quiprofile/GuildActivityWrapper$SupportVasThemeActivityWrapper;", "Lcom/tencent/mobileqq/guild/quiprofile/GuildActivityWrapper;", "Lcom/tencent/mobileqq/guild/quiprofile/c;", "createGuildProfileResources", "Landroidx/fragment/app/FragmentActivity;", PM.BASE, "<init>", "(Landroidx/fragment/app/FragmentActivity;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    @ArgusTag(tags = {"CUSTOM_CONTEXT"})
    /* loaded from: classes14.dex */
    public static final class SupportVasThemeActivityWrapper extends GuildActivityWrapper {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SupportVasThemeActivityWrapper(@NotNull FragmentActivity base) {
            super(base);
            Intrinsics.checkNotNullParameter(base, "base");
        }

        @Override // com.tencent.mobileqq.guild.quiprofile.GuildActivityWrapper
        @NotNull
        protected c createGuildProfileResources() {
            return new c(getBase(), null, 1000, false, 2, null);
        }

        @Override // com.tencent.mobileqq.guild.quiprofile.GuildActivityWrapper, com.tencent.mobileqq.app.QBaseActivityWrapper, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
            boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
            return dispatchTouchEvent;
        }

        @Override // com.tencent.mobileqq.guild.quiprofile.GuildActivityWrapper, com.tencent.mobileqq.app.QBaseActivityWrapper, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
            super.onConfigurationChanged(configuration);
            EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildActivityWrapper(@NotNull FragmentActivity base) {
        super(base);
        Intrinsics.checkNotNullParameter(base, "base");
        this.base = base;
        this.currentLayoutInflaters = new RFWThreadLocal<>();
        this.currentResource = new RFWThreadLocal<>();
    }

    @NotNull
    protected c createGuildProfileResources() {
        return new c(this.base, null, 1000, false, 10, null);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivityWrapper, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @NotNull
    public final FragmentActivity getBase() {
        return this.base;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivityWrapper, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    @NotNull
    public Resources getResources() {
        c cVar = this.currentResource.get();
        if (cVar == null) {
            cVar = createGuildProfileResources();
            this.currentResource.set(cVar);
        }
        if (enableCheckDensity()) {
            DisplayMetricsUtil.checkAndCorrectDensity(cVar.getSuperDisplayMetrics());
            com.tencent.mobileqq.app.displaymetric.a.f195491a.a(cVar);
        }
        return cVar;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivityWrapper, com.tencent.mobileqq.app.QBaseActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    @Nullable
    public Object getSystemService(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (Intrinsics.areEqual("layout_inflater", name)) {
            LayoutInflater layoutInflater = this.currentLayoutInflaters.get();
            if (layoutInflater == null) {
                Object systemService = super.getSystemService(name);
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
                LayoutInflater layoutInflater2 = (LayoutInflater) systemService;
                if (layoutInflater2 instanceof GuildQUIProfileLayoutInflater) {
                    GuildQUIProfileLayoutInflater guildQUIProfileLayoutInflater = (GuildQUIProfileLayoutInflater) layoutInflater2;
                    if (guildQUIProfileLayoutInflater.getContext() != this) {
                        layoutInflater2 = guildQUIProfileLayoutInflater.cloneInContext(this);
                    }
                    layoutInflater = layoutInflater2;
                } else {
                    layoutInflater = new GuildQUIProfileLayoutInflater(layoutInflater2, this);
                }
                this.currentLayoutInflaters.set(layoutInflater);
            }
            return layoutInflater;
        }
        return super.getSystemService(name);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivityWrapper, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
