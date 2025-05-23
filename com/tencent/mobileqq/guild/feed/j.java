package com.tencent.mobileqq.guild.feed;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.base.extension.m;
import com.tencent.mobileqq.guild.discoveryv2.content.base.MVPFeedsDataPart;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetFeedsByIndexReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProIndexFeedParam;
import ef1.c;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000bR\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0007\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/j;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/base/MVPFeedsDataPart;", "", "numStr", "", "Y9", "", "source", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGetFeedsByIndexReq;", "W9", "", "Lcom/tencent/mobileqq/guild/discoveryv2/content/model/f;", "J9", "vm", "Z9", "Landroid/os/Bundle;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/os/Bundle;", "getBundle", "()Landroid/os/Bundle;", "bundle", BdhLogUtil.LogTag.Tag_Conn, "I", "X9", "()I", "Lcom/tencent/mobileqq/guild/feed/GuildFeedViewModel;", "D", "Lcom/tencent/mobileqq/guild/feed/GuildFeedViewModel;", "mViewModel", "<init>", "(Landroid/os/Bundle;I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class j extends MVPFeedsDataPart {

    /* renamed from: C, reason: from kotlin metadata */
    private final int source;

    /* renamed from: D, reason: from kotlin metadata */
    private GuildFeedViewModel mViewModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Bundle bundle;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements ViewModelProvider.Factory {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewModelStoreOwner f219985a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ j f219986b;

        public a(ViewModelStoreOwner viewModelStoreOwner, j jVar) {
            this.f219985a = viewModelStoreOwner;
            this.f219986b = jVar;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> p06) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            long m1963markNowz9LOYto = TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto();
            j jVar = this.f219986b;
            TimedValue timedValue = new TimedValue(new GuildFeedViewModel(jVar.W9(jVar.getSource())), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(m1963markNowz9LOYto), null);
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildViewModelProvider", 2, "create " + m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
            }
            return (T) timedValue.getValue();
        }
    }

    public j(@Nullable Bundle bundle, int i3) {
        this.bundle = bundle;
        this.source = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GProGetFeedsByIndexReq W9(int source) {
        String str;
        int i3;
        Long longOrNull;
        long j3;
        Long longOrNull2;
        String string;
        Bundle bundle = this.bundle;
        String str2 = "";
        if (bundle == null || (str = bundle.getString("feed_my_post_guild_id")) == null) {
            str = "";
        }
        Bundle bundle2 = this.bundle;
        if (bundle2 != null && (string = bundle2.getString("feed_my_post_user_tiny_id")) != null) {
            str2 = string;
        }
        GProIndexFeedParam gProIndexFeedParam = new GProIndexFeedParam();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(str);
            long j16 = 0;
            if (longOrNull != null) {
                j3 = longOrNull.longValue();
            } else {
                j3 = 0;
            }
            gProIndexFeedParam.guildId = j3;
            longOrNull2 = StringsKt__StringNumberConversionsKt.toLongOrNull(str2);
            if (longOrNull2 != null) {
                j16 = longOrNull2.longValue();
            }
            gProIndexFeedParam.tinyid = j16;
            i3 = 3;
        } else if (source == 4) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        GProGetFeedsByIndexReq gProGetFeedsByIndexReq = new GProGetFeedsByIndexReq();
        gProGetFeedsByIndexReq.indexType = i3;
        gProGetFeedsByIndexReq.indexParam = gProIndexFeedParam;
        return gProGetFeedsByIndexReq;
    }

    private final void Y9(String numStr) {
        if (TextUtils.isEmpty(numStr)) {
            return;
        }
        broadcastMessage("message_update_title", getContext().getResources().getString(R.string.f144840pv, "(" + numStr + ")"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void aa(j this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Y9(str);
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.base.MVPFeedsDataPart
    @NotNull
    public List<com.tencent.mobileqq.guild.discoveryv2.content.model.f> J9() {
        List<com.tencent.mobileqq.guild.discoveryv2.content.model.f> listOf;
        c.Companion companion = ef1.c.INSTANCE;
        IPartHost partHost = getPartHost();
        Intrinsics.checkNotNullExpressionValue(partHost, "partHost");
        ViewModel viewModel = new ViewModelProvider(partHost, new a(partHost, this)).get(GuildFeedViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
        GuildFeedViewModel guildFeedViewModel = (GuildFeedViewModel) viewModel;
        Z9(guildFeedViewModel);
        this.mViewModel = guildFeedViewModel;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(viewModel);
        return listOf;
    }

    /* renamed from: X9, reason: from getter */
    public final int getSource() {
        return this.source;
    }

    public final void Z9(@NotNull com.tencent.mobileqq.guild.discoveryv2.content.model.f vm5) {
        Intrinsics.checkNotNullParameter(vm5, "vm");
        if (vm5 instanceof GuildFeedViewModel) {
            LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
            ((GuildFeedViewModel) vm5).u2(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.feed.i
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    j.aa(j.this, (String) obj);
                }
            });
        }
    }
}
