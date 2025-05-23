package com.tencent.mobileqq.guild.media.content;

import com.tencent.mobileqq.guild.media.GuildMediaChannelViewModel;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\rR\"\u0010\u0015\u001a\u00020\t8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u001c\u001a\u00020\r8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/guild/media/content/GuildMediaContentFragmentBase;", "Landroidx/fragment/app/Fragment;", "Lcom/tencent/mobileqq/guild/media/content/i;", "", "kd", "C0", "rh", "onBackEvent", "J2", "Lcom/tencent/mobileqq/guild/media/GuildMediaChannelViewModel;", "viewModel", "", "sh", "Lcom/tencent/mobileqq/guild/media/viewmodel/b;", "vh", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/media/GuildMediaChannelViewModel;", "ph", "()Lcom/tencent/mobileqq/guild/media/GuildMediaChannelViewModel;", "th", "(Lcom/tencent/mobileqq/guild/media/GuildMediaChannelViewModel;)V", "mChannelViewModel", "D", "Lcom/tencent/mobileqq/guild/media/viewmodel/b;", "qh", "()Lcom/tencent/mobileqq/guild/media/viewmodel/b;", "uh", "(Lcom/tencent/mobileqq/guild/media/viewmodel/b;)V", "mMicStateViewModel", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public class GuildMediaContentFragmentBase extends ReportAndroidXFragment implements i {

    /* renamed from: C, reason: from kotlin metadata */
    protected GuildMediaChannelViewModel mChannelViewModel;

    /* renamed from: D, reason: from kotlin metadata */
    protected com.tencent.mobileqq.guild.media.viewmodel.b mMicStateViewModel;

    public boolean C0() {
        return false;
    }

    public boolean J2() {
        return false;
    }

    public boolean kd() {
        return false;
    }

    @Override // com.tencent.mobileqq.guild.media.content.i
    public boolean onBackEvent() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final GuildMediaChannelViewModel ph() {
        GuildMediaChannelViewModel guildMediaChannelViewModel = this.mChannelViewModel;
        if (guildMediaChannelViewModel != null) {
            return guildMediaChannelViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mChannelViewModel");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final com.tencent.mobileqq.guild.media.viewmodel.b qh() {
        com.tencent.mobileqq.guild.media.viewmodel.b bVar = this.mMicStateViewModel;
        if (bVar != null) {
            return bVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mMicStateViewModel");
        return null;
    }

    public boolean rh() {
        return false;
    }

    public final void sh(@NotNull GuildMediaChannelViewModel viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        th(viewModel);
        ph().c2().setValue(Boolean.valueOf(C0()));
        ph().Q1().setValue(Boolean.valueOf(rh()));
    }

    protected final void th(@NotNull GuildMediaChannelViewModel guildMediaChannelViewModel) {
        Intrinsics.checkNotNullParameter(guildMediaChannelViewModel, "<set-?>");
        this.mChannelViewModel = guildMediaChannelViewModel;
    }

    protected final void uh(@NotNull com.tencent.mobileqq.guild.media.viewmodel.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.mMicStateViewModel = bVar;
    }

    public final void vh(@NotNull com.tencent.mobileqq.guild.media.viewmodel.b viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        uh(viewModel);
    }
}
