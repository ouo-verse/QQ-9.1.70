package com.tencent.mobileqq.guild.feed.nativepublish.root;

import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;
import yl1.i;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\"\u0010\t\u001a\u00020\b2\u0010\u0010\u0005\u001a\f\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u001a\u0010\u000f\u001a\u00020\n8\u0014X\u0094D\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/root/c;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/vmdelegate/a;", "Lcom/tencent/base/api/runtime/a;", "Lzl1/a;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/FeedEditorContext;", "context", "", QCircleFolderFunnelCollect.LAUNCH_TYPE_REUSE, "", "e", "", h.F, "Ljava/lang/String;", "getLogTag", "()Ljava/lang/String;", "logTag", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class c extends com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.a {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String logTag;

    public c() {
        super(null, 1, null);
        this.logTag = "FeedEditor.GlobalSharedStateManage";
    }

    @Override // com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.a, com.tencent.input.base.mvicompat.f
    /* renamed from: e */
    public void b(@NotNull com.tencent.base.api.runtime.a<zl1.a> context, boolean reuse) {
        IGProChannelInfo B;
        Intrinsics.checkNotNullParameter(context, "context");
        super.b(context, reuse);
        zl1.a onCreate$lambda$0 = context.h();
        boolean z16 = false;
        onCreate$lambda$0.getMutableGlobalSharedState().b(false);
        Intrinsics.checkNotNullExpressionValue(onCreate$lambda$0, "onCreate$lambda$0");
        int i3 = 1;
        if (onCreate$lambda$0.a().length() > 0) {
            z16 = true;
        }
        if (z16 && (B = ch.B(onCreate$lambda$0.a())) != null) {
            i3 = i.f450608a.m(B.isHiddenPostChannel());
        }
        zl1.b.p(onCreate$lambda$0, i3);
    }
}
