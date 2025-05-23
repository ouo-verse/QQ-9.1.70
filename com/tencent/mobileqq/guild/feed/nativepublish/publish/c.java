package com.tencent.mobileqq.guild.feed.nativepublish.publish;

import android.content.Context;
import android.os.Bundle;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.input.base.mvicompat.ex.VMMessengerProtocolSupport;
import com.tencent.input.base.mvicompat.ex.a;
import com.tencent.input.base.mvicompat.f;
import com.tencent.mobileqq.guild.feed.nativepublish.content.FeedEditorContentMsgIntent;
import com.tencent.mobileqq.guild.feed.topic.GuildTopicFragment;
import com.tencent.mobileqq.guild.feed.topic.TopicLaunchParams;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.j;
import com.tencent.mvi.base.route.k;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001c2\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`\u00040\u00012\u00020\u0005:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J\"\u0010\u000f\u001a\u00020\u00062\u0010\u0010\f\u001a\f\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0016R\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0015R \u0010\u0019\u001a\f\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/publish/c;", "Lcom/tencent/input/base/mvicompat/f;", "Lcom/tencent/base/api/runtime/a;", "Lzl1/a;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/FeedEditorContext;", "Lcom/tencent/input/base/mvicompat/ex/a;", "", "a", "c", "", "", "J2", "context", "", QCircleFolderFunnelCollect.LAUNCH_TYPE_REUSE, "d", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mvi/base/route/MsgIntent;", "event", "E", "Lcom/tencent/input/base/mvicompat/ex/VMMessengerProtocolSupport;", "Lcom/tencent/input/base/mvicompat/ex/VMMessengerProtocolSupport;", "messageHandlerSupport", "e", "Lcom/tencent/base/api/runtime/a;", "editorContext", "<init>", "()V", "f", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class c implements f<com.tencent.base.api.runtime.a<zl1.a>>, com.tencent.input.base.mvicompat.ex.a {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final VMMessengerProtocolSupport messageHandlerSupport = new VMMessengerProtocolSupport(this);

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.base.api.runtime.a<zl1.a> editorContext;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ*\u0010\u0007\u001a\u0014\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`\u0004\u0018\u00010\u00062\u0010\u0010\u0005\u001a\f\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/publish/c$a;", "", "Lcom/tencent/base/api/runtime/a;", "Lzl1/a;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/FeedEditorContext;", "context", "Lcom/tencent/input/base/mvicompat/f;", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.nativepublish.publish.c$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final f<com.tencent.base.api.runtime.a<zl1.a>> a(@NotNull com.tencent.base.api.runtime.a<zl1.a> context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (context.h().getOnPublishRedirectActionId() == 0) {
                return null;
            }
            return new c();
        }

        Companion() {
        }
    }

    private final void a() {
        boolean z16;
        boolean z17;
        boolean z18;
        Context requireContext;
        com.tencent.base.api.runtime.a<zl1.a> aVar = this.editorContext;
        com.tencent.base.api.runtime.a<zl1.a> aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editorContext");
            aVar = null;
        }
        String h16 = aVar.h().h();
        com.tencent.base.api.runtime.a<zl1.a> aVar3 = this.editorContext;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editorContext");
            aVar3 = null;
        }
        String a16 = aVar3.h().a();
        boolean z19 = true;
        if (h16.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (a16.length() == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                com.tencent.base.api.runtime.a<zl1.a> aVar4 = this.editorContext;
                if (aVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("editorContext");
                    aVar4 = null;
                }
                String string = aVar4.h().getExtra().getString("sgrp_stream_pgin_source_name");
                if (string != null && string.length() != 0) {
                    z18 = false;
                } else {
                    z18 = true;
                }
                if (z18) {
                    string = null;
                }
                if (string != null) {
                    com.tencent.mobileqq.guild.report.b.g(string, "PublishFeedRedirectActionPatch");
                }
                com.tencent.base.api.runtime.a<zl1.a> aVar5 = this.editorContext;
                if (aVar5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("editorContext");
                    aVar5 = null;
                }
                String string2 = aVar5.h().getExtra().getString("sgrp_visit_from");
                if (string2 != null && string2.length() != 0) {
                    z19 = false;
                }
                if (z19) {
                    string2 = null;
                }
                if (string2 != null) {
                    com.tencent.mobileqq.guild.report.b.i(string2, "PublishFeedRedirectActionPatch");
                }
                com.tencent.base.api.runtime.a<zl1.a> aVar6 = this.editorContext;
                if (aVar6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("editorContext");
                    aVar6 = null;
                }
                Bundle extra = aVar6.h().getExtra();
                if (extra.getBoolean("use_new_task_to_launch_redirect_page", false)) {
                    requireContext = BaseApplication.getContext();
                } else {
                    com.tencent.base.api.runtime.a<zl1.a> aVar7 = this.editorContext;
                    if (aVar7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("editorContext");
                    } else {
                        aVar2 = aVar7;
                    }
                    requireContext = aVar2.c().requireContext();
                }
                Intrinsics.checkNotNullExpressionValue(requireContext, "if (isNewTask) BaseAppli\u2026fragment.requireContext()");
                JumpGuildParam jumpGuildParam = new JumpGuildParam(h16, "", (JumpGuildParam.JoinInfoParam) extra.getParcelable(JumpGuildParam.KEY_JOIN_INFO_PARAM));
                Bundle bundle = extra.getBundle(JumpGuildParam.EXTRA_BACK_TO_THIRD_APP);
                if (bundle != null) {
                    jumpGuildParam.extras.putBundle(JumpGuildParam.EXTRA_BACK_TO_THIRD_APP, bundle);
                }
                d12.a.d(requireContext, jumpGuildParam);
                return;
            }
        }
        QLog.w("PublishFeedRedirectActionPatch", 1, "handleRedirectAction|guildId and channelId must not be empty");
    }

    private final void c() {
        boolean z16;
        com.tencent.base.api.runtime.a<zl1.a> aVar = this.editorContext;
        com.tencent.base.api.runtime.a<zl1.a> aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editorContext");
            aVar = null;
        }
        zl1.a h16 = aVar.h();
        Intrinsics.checkNotNullExpressionValue(h16, "editorContext.baseParam");
        Long f16 = zl1.b.f(h16);
        com.tencent.base.api.runtime.a<zl1.a> aVar3 = this.editorContext;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editorContext");
            aVar3 = null;
        }
        String h17 = aVar3.h().h();
        if (f16 != null && f16.longValue() != 0) {
            if (h17.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                GuildTopicFragment.Companion companion = GuildTopicFragment.INSTANCE;
                com.tencent.base.api.runtime.a<zl1.a> aVar4 = this.editorContext;
                if (aVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("editorContext");
                    aVar4 = null;
                }
                Context requireContext = aVar4.c().requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "editorContext.fragment.requireContext()");
                long longValue = f16.longValue();
                com.tencent.base.api.runtime.a<zl1.a> aVar5 = this.editorContext;
                if (aVar5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("editorContext");
                } else {
                    aVar2 = aVar5;
                }
                zl1.a h18 = aVar2.h();
                Intrinsics.checkNotNullExpressionValue(h18, "editorContext.baseParam");
                companion.a(requireContext, new TopicLaunchParams(longValue, zl1.b.g(h18), null, h17, 4, null));
                return;
            }
        }
        QLog.w("PublishFeedRedirectActionPatch", 1, "handleRedirectAction|topicId or guildId must not be 0 or null");
    }

    @Override // com.tencent.input.base.mvicompat.ex.a
    public void E(@NotNull MsgIntent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (!(event instanceof FeedEditorContentMsgIntent.OnTriggerPublishEvent)) {
            return;
        }
        com.tencent.base.api.runtime.a<zl1.a> aVar = this.editorContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editorContext");
            aVar = null;
        }
        int onPublishRedirectActionId = aVar.h().getOnPublishRedirectActionId();
        if (onPublishRedirectActionId != 1) {
            if (onPublishRedirectActionId == 2) {
                c();
                return;
            }
            return;
        }
        a();
    }

    @Override // com.tencent.input.base.mvicompat.ex.a
    @NotNull
    public k I(@NotNull MsgIntent msgIntent) {
        return a.C5857a.d(this, msgIntent);
    }

    @Override // com.tencent.input.base.mvicompat.ex.a
    @NotNull
    public List<String> J2() {
        List<String> listOf;
        String b16 = com.tencent.mvi.base.route.c.b(FeedEditorContentMsgIntent.OnTriggerPublishEvent.class);
        Intrinsics.checkNotNullExpressionValue(b16, "get(java)");
        listOf = CollectionsKt__CollectionsJVMKt.listOf(b16);
        return listOf;
    }

    @Override // com.tencent.input.base.mvicompat.f
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void b(@NotNull com.tencent.base.api.runtime.a<zl1.a> context, boolean reuse) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.editorContext = context;
        VMMessengerProtocolSupport vMMessengerProtocolSupport = this.messageHandlerSupport;
        j e16 = context.e();
        Intrinsics.checkNotNullExpressionValue(e16, "context.messenger");
        vMMessengerProtocolSupport.d(e16);
    }

    @Override // com.tencent.input.base.mvicompat.ex.a
    @Nullable
    public List<String> f0() {
        return a.C5857a.b(this);
    }

    @Override // com.tencent.input.base.mvicompat.f
    public void onDestroy() {
        VMMessengerProtocolSupport vMMessengerProtocolSupport = this.messageHandlerSupport;
        com.tencent.base.api.runtime.a<zl1.a> aVar = this.editorContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editorContext");
            aVar = null;
        }
        j e16 = aVar.e();
        Intrinsics.checkNotNullExpressionValue(e16, "editorContext.messenger");
        vMMessengerProtocolSupport.e(e16);
    }
}
