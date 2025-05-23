package com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.core.util.Supplier;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.part.PartIOCKt;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.guild.data.GuildSimpleContact;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.logic.BottomGuideBarDelegateDefaultImpl;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/interactive/layout/main/logic/BottomGuideBarDelegateDefaultImpl;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
final class BottomInteractivePart$inputContextProvider$1$guildBarDependency$2 extends Lambda implements Function0<BottomGuideBarDelegateDefaultImpl> {
    final /* synthetic */ BottomInteractivePart$inputContextProvider$1 this$0;
    final /* synthetic */ BottomInteractivePart this$1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomInteractivePart$inputContextProvider$1$guildBarDependency$2(BottomInteractivePart$inputContextProvider$1 bottomInteractivePart$inputContextProvider$1, BottomInteractivePart bottomInteractivePart) {
        super(0);
        this.this$0 = bottomInteractivePart$inputContextProvider$1;
        this.this$1 = bottomInteractivePart;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer e(BottomInteractivePart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return Integer.valueOf(GuildSplitViewUtils.f235370a.h(this$0.getPartHost()).getInt("business_type", 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JumpGuildParam.JoinInfoParam f(BottomInteractivePart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return (JumpGuildParam.JoinInfoParam) GuildSplitViewUtils.f235370a.h(this$0.getPartHost()).getParcelable("join_info_param");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String g(BottomInteractivePart this$0) {
        Activity hostActivity;
        Intent intent;
        String stringExtra;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IPartHost partHost = this$0.getPartHost();
        if (partHost == null || (hostActivity = partHost.getHostActivity()) == null || (intent = hostActivity.getIntent()) == null || (stringExtra = intent.getStringExtra("sgrp_channel_extension_info")) == null) {
            return "";
        }
        return stringExtra;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(BottomInteractivePart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        rl1.b bVar = (rl1.b) PartIOCKt.getIocInterface(this$0, rl1.b.class);
        if (bVar != null) {
            bVar.e9(null);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final BottomGuideBarDelegateDefaultImpl invoke() {
        Context context = this.this$0.getContext();
        GuildSimpleContact guildSimpleContact = new GuildSimpleContact(this.this$0.getGuildId(), this.this$0.getChannelId());
        final BottomInteractivePart bottomInteractivePart = this.this$1;
        Supplier supplier = new Supplier() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.b
            @Override // androidx.core.util.Supplier
            public final Object get() {
                Integer e16;
                e16 = BottomInteractivePart$inputContextProvider$1$guildBarDependency$2.e(BottomInteractivePart.this);
                return e16;
            }
        };
        final BottomInteractivePart bottomInteractivePart2 = this.this$1;
        Supplier supplier2 = new Supplier() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.c
            @Override // androidx.core.util.Supplier
            public final Object get() {
                JumpGuildParam.JoinInfoParam f16;
                f16 = BottomInteractivePart$inputContextProvider$1$guildBarDependency$2.f(BottomInteractivePart.this);
                return f16;
            }
        };
        final BottomInteractivePart bottomInteractivePart3 = this.this$1;
        Supplier supplier3 = new Supplier() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.d
            @Override // androidx.core.util.Supplier
            public final Object get() {
                String g16;
                g16 = BottomInteractivePart$inputContextProvider$1$guildBarDependency$2.g(BottomInteractivePart.this);
                return g16;
            }
        };
        Fragment hostFragment = this.this$1.getHostFragment();
        LiveData<LifecycleOwner> viewLifecycleOwnerLiveData = hostFragment != null ? hostFragment.getViewLifecycleOwnerLiveData() : null;
        if (viewLifecycleOwnerLiveData == null) {
            viewLifecycleOwnerLiveData = new MutableLiveData<>(null);
        }
        BottomGuideBarDelegateDefaultImpl bottomGuideBarDelegateDefaultImpl = new BottomGuideBarDelegateDefaultImpl(context, guildSimpleContact, supplier, supplier2, supplier3, viewLifecycleOwnerLiveData, false, 64, null);
        final BottomInteractivePart bottomInteractivePart4 = this.this$1;
        bottomGuideBarDelegateDefaultImpl.y(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.e
            @Override // java.lang.Runnable
            public final void run() {
                BottomInteractivePart$inputContextProvider$1$guildBarDependency$2.h(BottomInteractivePart.this);
            }
        });
        return bottomGuideBarDelegateDefaultImpl;
    }
}
